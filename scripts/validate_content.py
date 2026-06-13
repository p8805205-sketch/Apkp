#!/usr/bin/env python3
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
SOURCE = ROOT / "app" / "src" / "main" / "java" / "com" / "sumberilmu" / "app" / "data" / "GeneratedContent.kt"


def fail(message: str) -> None:
    raise SystemExit(f"CONTENT VALIDATION FAILED: {message}")


def main() -> None:
    text = SOURCE.read_text(encoding="utf-8")
    required = [
        'appName = "Sumber Ilmu"',
        'passScore = 75',
        'quizQuestionsPerChapter = 25',
        'List(25)',
    ]
    for marker in required:
        if marker not in text:
            fail(f"missing marker: {marker}")

    chapter_count = text.count("number = ")
    if chapter_count != 9:
        fail(f"expected 9 chapter definitions, found {chapter_count}")

    print("Content valid: 9 chapters, 25 quiz items per chapter, pass score 75.")


if __name__ == "__main__":
    main()
