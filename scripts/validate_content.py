#!/usr/bin/env python3
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
DATA_DIR = ROOT / "app" / "src" / "main" / "java" / "com" / "sumberilmu" / "app" / "data"
GENERATED = DATA_DIR / "GeneratedContent.kt"
CURATED_ONE = DATA_DIR / "CuratedChapterOne.kt"
QUIZ_ONE = DATA_DIR / "ChapterOneQuiz.kt"


def fail(message: str) -> None:
    raise SystemExit(f"CONTENT VALIDATION FAILED: {message}")


def require_markers(text: str, markers: list[str], source: str) -> None:
    for marker in markers:
        if marker not in text:
            fail(f"{source} is missing marker: {marker}")


def main() -> None:
    generated = GENERATED.read_text(encoding="utf-8")
    curated = CURATED_ONE.read_text(encoding="utf-8")
    quiz = QUIZ_ONE.read_text(encoding="utf-8")

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

    require_markers(
        curated,
        [
            'id = "bab-1"',
            'sourcePageStart = 1',
            'sourcePageEnd = 28',
            'quiz = ChapterOneQuiz.questions',
            'title = "Perkalian dan Pembagian"',
        ],
        "CuratedChapterOne.kt",
    )

    question_ids = [int(value) for value in re.findall(r"id = (\d+),", quiz)]
    if question_ids != list(range(1, 26)):
        fail(f"Bab 1 quiz IDs must be 1..25, found {question_ids}")

    if quiz.count("sourcePage = ") != 26:
        fail("Bab 1 must contain 25 source page references plus one helper parameter")

    print("Content valid: 9 chapters, curated Bab 1, 25 verified quiz records, pass score 75.")


if __name__ == "__main__":
    main()
