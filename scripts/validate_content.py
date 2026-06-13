#!/usr/bin/env python3
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
DATA_DIR = ROOT / "app" / "src" / "main" / "java" / "com" / "sumberilmu" / "app" / "data"
GENERATED = DATA_DIR / "GeneratedContent.kt"
CHAPTER_NAMES = {1: "One", 2: "Two", 3: "Three"}


def fail(message: str) -> None:
    raise SystemExit(f"CONTENT VALIDATION FAILED: {message}")


def require_markers(text: str, markers: list[str], source: str) -> None:
    for marker in markers:
        if marker not in text:
            fail(f"{source} is missing marker: {marker}")


def validate_quiz(chapter_number: int) -> None:
    chapter_name = CHAPTER_NAMES[chapter_number]
    path = DATA_DIR / f"Chapter{chapter_name}Quiz.kt"
    text = path.read_text(encoding="utf-8")
    question_ids = [int(value) for value in re.findall(r"id = (\d+),", text)]
    if question_ids != list(range(1, 26)):
        fail(f"Bab {chapter_number} quiz IDs must be 1..25, found {question_ids}")
    if text.count("sourcePage = ") != 26:
        fail(f"Bab {chapter_number} must contain 25 source pages plus one helper assignment")
    if text.count("options = listOf(") != 25:
        fail(f"Bab {chapter_number} must contain 25 option lists")
    if text.count("difficulty = ") != 26:
        fail(f"Bab {chapter_number} must contain difficulty metadata for every question")


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

    curated_requirements = {
        1: [
            'sourcePageStart = 1',
            'sourcePageEnd = 28',
            'quiz = ChapterOneQuiz.questions',
            'title = "Perkalian dan Pembagian"',
        ],
        2: [
            'sourcePageStart = 29',
            'sourcePageEnd = 62',
            'quiz = ChapterTwoQuiz.questions',
            'title = "Bilangan Prima dan Saringan Eratosthenes"',
            'title = "Menentukan KPK dan FPB dengan Faktorisasi Prima"',
        ],
        3: [
            'sourcePageStart = 63',
            'sourcePageEnd = 104',
            'quiz = ChapterThreeQuiz.questions',
            'title = "Membandingkan dan Mengurutkan Pecahan"',
            'title = "Pengurangan Pecahan Berbeda Penyebut dan Pecahan Campuran"',
        ],
    }

    for chapter_number, markers in curated_requirements.items():
        chapter_name = CHAPTER_NAMES[chapter_number]
        path = DATA_DIR / f"CuratedChapter{chapter_name}.kt"
        text = path.read_text(encoding="utf-8")
        require_markers(
            text,
            [f'id = "bab-{chapter_number}"'] + markers,
            path.name,
        )
        validate_quiz(chapter_number)

    print("Content valid: 9 chapters, curated Bab 1-3, 75 verified quiz records, pass score 75.")


if __name__ == "__main__":
    main()
