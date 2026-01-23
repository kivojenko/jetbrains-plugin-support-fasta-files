# FASTA Format Support (JetBrains IDEs)

FASTA Format Support is a JetBrains plugin that adds first‑class support for FASTA files used in bioinformatics for nucleic acid (DNA/RNA) and protein sequences.

It provides syntax highlighting, folding, structure view, formatting, hints, color settings and handy editor intentions for transforming sequences.

## Change Log

- **v1.0.3**: Add support for comments and ambiguous characters in protein sequences.
- **v1.0.2**: Bug fix.
- **v1.0.1**: Add inlay hints for length, GC content, ambiguity and molecular weight.
- **v1.0.0**: Initial release with core functionality: grammar, folding, highlighting, structure view.

## Features

- Recognizes FASTA files and associates common extensions: `.fasta`, `.fas`, `.fa`, `.fna`, `.ffn`, `.faa`, `.mpfa`, `.frn`.
- Syntax highlighting with configurable color scheme.
- Code folding of long sequences and records.
- Structure view and navigation by headers/records.
- Code style/formatting support for wrapping and spacing.
- Post-format processing tailored for FASTA content.
- Editor intentions (Alt+Enter) for common sequence transformations:
    - Reverse sequence
    - Get reverse complement (DNA/RNA)
    - Translate to protein (uses BioJava)

## Building lexer/parser

The repository includes generated sources under `src/main/gen`. If you need to regenerate:

- Lexer: `src/main/resources/lexer/Fasta.flex` (JFlex)
- Grammar/Parser/PSI: `src/main/resources/lexer/Fasta.bnf`

JetBrains Grammar-Kit and JFlex support can be used in IDE to regenerate these artifacts.

## Compatibility

- Plugin id: `com.kivojenko.plugin.fasta`
- Since-build: 231+
- Target IDE in build script: IntelliJ IDEA 2025.1.2 (with Java plugin)

## Feedback and Contributions

Your feedback is essential for improving this plugin!

### Ways to Get Involved:

- **Report Bugs**: If you encounter any issues, please create a bug report in this repository’s [issues section](#).
- **Request Features**: Have an idea to make this plugin even better? Submit a feature request!
- **Contribute Code**: Pull requests are always welcome if you'd like to contribute directly.

### Contact

For any questions or direct feedback, feel free to reach me at:  
📧 **kivojenko@gmail.com**

## License

This plugin is open-source and licensed under the [Apache License 2.0](LICENSE).
