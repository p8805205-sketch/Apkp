#!/usr/bin/env python3
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
DATA = ROOT / "app/src/main/java/com/sumberilmu/app/data"
NAMES = {1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five", 6: "Six"}


def fail(message: str) -> None:
    raise SystemExit(f"CONTENT VALIDATION FAILED: {message}")


def markers(path: Path, required: list[str]) -> None:
    text = path.read_text(encoding="utf-8")
    for marker in required:
        if marker not in text:
            fail(f"{path.name} missing: {marker}")


def validate_legacy(number: int, name: str) -> None:
    text = (DATA / f"Chapter{name}Quiz.kt").read_text(encoding="utf-8")
    ids = [int(x) for x in re.findall(r"id = (\d+),", text)]
    if ids != list(range(1, 26)):
        fail(f"Bab {number} IDs invalid: {ids}")
    if text.count("options = listOf(") != 25:
        fail(f"Bab {number} option lists invalid")


def validate_modular(number: int, name: str) -> None:
    texts = [p.read_text(encoding="utf-8") for p in sorted(DATA.glob(f"Chapter{name}Quiz*.kt"))]
    text = "\n".join(texts)
    ids = [int(x) for x in re.findall(r"\bq\((\d+),", text)]
    ids += [int(x) for x in re.findall(rf"CuratedQuestionFactory\.create\({number},\s*(\d+),", text)]
    if sorted(ids) != list(range(1, 26)):
        fail(f"Bab {number} modular IDs invalid: {sorted(ids)}")
    if len(re.findall(r'listOf\("', text)) != 25:
        fail(f"Bab {number} must have 25 option lists")


def main() -> None:
    generated = DATA / "GeneratedContent.kt"
    markers(generated, [
        'appName = "Sumber Ilmu"', 'passScore = 75',
        'quizQuestionsPerChapter = 25', 'List(25)',
    ] + [f"number = {n}," for n in range(1, 10)])

    markers(DATA / "CuratedQuestionFactory.kt", [
        "require(options.size == 4)",
        "require(options.toSet().size == 4)",
        'id = "bab-$chapterNumber-soal-$id"',
    ])

    chapter_files = {
        1: ("CuratedChapterOne.kt", "sourcePageEnd = 28"),
        2: ("CuratedChapterTwo.kt", "sourcePageEnd = 62"),
        3: ("CuratedChapterThree.kt", "sourcePageEnd = 104"),
        4: ("CuratedChapterFour.kt", "sourcePageEnd = 130"),
        5: ("ChapterFiveLessonsFoundation.kt", "sourcePageEnd = 162"),
        6: ("CuratedChapterSix.kt", "sourcePageEnd = 190"),
    }
    for number, (filename, end_marker) in chapter_files.items():
        markers(DATA / filename, [f'id = "bab-{number}"', end_marker, f"quiz = Chapter{NAMES[number]}Quiz.questions"])
        if number <= 3:
            validate_legacy(number, NAMES[number])
        else:
            validate_modular(number, NAMES[number])

    repository = DATA / "ContentRepository.kt"
    markers(repository, [
        "CuratedChapterFive.chapter.id -> CuratedChapterFive.chapter",
        "CuratedChapterSix.chapter.id -> CuratedChapterSix.chapter",
        "rumus 4 × sisi hanya berlaku jika keempat sisi sama panjang",
        "auditedChapterFour()",
    ])

    bab4 = "\n".join(p.read_text(encoding="utf-8") for p in DATA.glob("ChapterFourQuiz*.kt"))
    for value in ['"24 cm"', '"80 cm"', '"46 cm"', '"Berlaku ketika keempat sisi sama panjang"']:
        if value not in bab4:
            fail(f"Bab 4 audit marker missing: {value}")

    bab5 = "\n".join(p.read_text(encoding="utf-8") for p in DATA.glob("ChapterFiveQuiz*.kt"))
    for value in ['"216 cm²"', '"224 cm²"', '"22 satuan luas"', '"20 satuan luas"']:
        if value not in bab5:
            fail(f"Bab 5 verification marker missing: {value}")

    bab6 = "\n".join(p.read_text(encoding="utf-8") for p in DATA.glob("ChapterSixQuiz*.kt"))
    for value in ['"30°"', '"120°"', '"180°"', '"235°"', '"36°"']:
        if value not in bab6:
            fail(f"Bab 6 verification marker missing: {value}")

    chapter_six = (DATA / "CuratedChapterSix.kt").read_text(encoding="utf-8")
    for value in [
        'title = "Mengenal Jenis-Jenis Sudut"',
        'title = "Mengukur Sudut dengan Busur Derajat"',
        'title = "Sudut dalam Persimpangan dan Pola Keramik"',
    ]:
        if value not in chapter_six:
            fail(f"Bab 6 lesson marker missing: {value}")

    ui = ROOT / "app/src/main/java/com/sumberilmu/app/ui"
    markers(ui / "AngleLearningVisual.kt", [
        "fun AngleLearningShowcase",
        "Canvas(",
        "selectedDegree",
        "Sudut refleks",
        "contentDescription = \"Visual sudut",
    ])
    markers(ui / "SumberIlmuApp.kt", [
        "if (chapter.number == 6)",
        "AngleEnhancedChapterScreen(",
    ])

    print("Content valid: 9 chapters, curated Bab 1-6, 150 verified quiz records, pass score 75, angle visual enabled.")


if __name__ == "__main__":
    main()
