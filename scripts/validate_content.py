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
    required.extend([f"number = {number}," for number in range(1, 10)])

    for marker in required:
        if marker not in text:
            fail(f"missing marker: {marker}")

    print("Content valid: 9 chapters, 25 quiz items per chapter, pass score 75.")


if __name__ == "__main__":
    main()
