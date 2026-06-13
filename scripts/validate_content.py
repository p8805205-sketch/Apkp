#!/usr/bin/env python3
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
DATA_DIR = ROOT / "app" / "src" / "main" / "java" / "com" / "sumberilmu" / "app" / "data"
GENERATED = DATA_DIR / "GeneratedContent.kt"


def fail(message: str) -> None:
    raise SystemExit(f"CONTENT VALIDATION FAILED: {message}")


def require_markers(text: str, markers: list[str], source: str) -> None:
    for marker in markers:
        if marker not in text:
            fail(f"{source} is missing marker: {marker}")


def validate_quiz(chapter_number: int) -> None:
    path = DATA_DIR / f"Chapter{['Zero', 'One', 'Two'][chapter_number]}Quiz.kt"
    text = path.read_text(encoding="utf-8")
    question_ids = [int(value) for value in re.findall(r"id = (\d+),", text)]
    if question_ids != list(range(1, 26)):
        fail(f"Bab {chapter_number} quiz IDs must be 1..25, found {question_ids}")
    if text.count("sourcePage = ") != 26:
        fail(f"Bab {chapter_number} must contain 25 source pages plus one helper assignment")
    if text.count("options = listOf(") != 25:
        fail(f"Bab {chapter_number} must contain 25 option lists")


def main() -> None:
    generated = GENERATED.read_text(encoding="utf-8")
    require_markers(
        generated,
        [
            'appName = "Sumber Ilmu"',
            'passScore = 75',
            'quizQuestionsPerChapter = 25',
            'List(25)',
        ] + [f"number = {number}," for number in range(1, 10)],
        "GeneratedContent.kt",
    )

    curated_one = (DATA_DIR / "CuratedChapterOne.kt").read_text(encoding="utf-8")
    require_markers(
        curated_one,
        [
            'id = "bab-1"',
            'sourcePageStart = 1',
            'sourcePageEnd = 28',
            'quiz = ChapterOneQuiz.questions',
            'title = "Perkalian dan Pembagian"',
        ],
        "CuratedChapterOne.kt",
    )

    curated_two = (DATA_DIR / "CuratedChapterTwo.kt").read_text(encoding="utf-8")
    require_markers(
        curated_two,
        [
            'id = "bab-2"',
            'sourcePageStart = 29',
            'sourcePageEnd = 62',
            'quiz = ChapterTwoQuiz.questions',
            'title = "Bilangan Prima dan Saringan Eratosthenes"',
            'title = "Menentukan KPK dan FPB dengan Faktorisasi Prima"',
        ],
        "CuratedChapterTwo.kt",
    )

    validate_quiz(1)
    validate_quiz(2)
    print("Content valid: 9 chapters, curated Bab 1-2, 50 verified quiz records, pass score 75.")


if __name__ == "__main__":
    main()
