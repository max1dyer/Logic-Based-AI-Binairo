Logic Based Binairo Solver Project using Prolog Constraint Programming (COGS 4962)

This project is a constraint-logic solver for Binairo implemented in SWI-Prolog using clpfd. It takes a partially filled Binairo grid and completes through declarative logic. The solver supports arbitrary even board sizes ≥ 4, and includes sample puzzles for testing.

Binairo is a logic puzzle played on an even-numbered square grid. Each cell is either 0 or 1. The puzzle has three rules:
1. Each row and column must contain an equal number of 0s and 1s
2. No row or column can contain 000 or 111
3. No two rows or two columns may be identical

To run:
1. Open SWI-Prolog
2. Change working directory to the folder with binairo.pl -- working_directory(_, 'PUT DIRECTORY HERE').
3. Load the file -- [binairo].
4. Run one of the preset demonstration puzzles -- binairo_demo('EXAMPLE NUMBER').
5. Run a board of your own design, see the demonstration puzzles for specifics on board layout -- binairo('BOARD', 'LENGTH OF BOARD').

To see the official write up for this project see the Binairo pdf.
