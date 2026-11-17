# Projeto2ADA — Can Rob Escape?

A computational-geometry puzzle solved with **union-find**: given a rectangular room and a set of circular beams, can a robot of a given diameter squeeze out without touching anything?

Written in Java for the *Análise e Desenho de Algoritmos* course at Instituto Superior Técnico.

## The idea

A robot can escape if and only if there is a path from the bottom wall to the top wall that is at least one robot diameter wide. Equivalently, escape is **impossible** when obstacles form a continuous chain connecting the two walls.

So instead of reasoning about the robot's path, the program tests whether the **obstacles** connect:

1. Represent the bottom and top walls as two extra nodes.
2. Union a beam with the bottom wall if it sits within one diameter of it; same for the top wall.
3. Union any two beams whose centres are closer than one diameter.
4. If the bottom and top walls end up in the same set, the chain is closed and the robot is trapped.

Union-find with path compression makes the whole test effectively linear in the number of beams.

## Input

```
4 5          # room length and width
1            # robot diameter
3            # number of beams
0 1
2 2
4 1
```

- Line 1: room dimensions (`length`, `width`).
- Line 2: robot diameter.
- Line 3: number of beams.
- Next `n` lines: beam coordinates `x y`.

## Output

```
Rob manages to escape!
```

or

```
Impossible to escape
```

## Run

```bash
javac src/*.java -d out
java -cp out Main
```

The program reads from standard input.

## Structure

| File | Responsibility |
|---|---|
| `src/Main.java` | Input parsing, result printing |
| `src/RobotEscapeSystem.java` | Connectivity test over beams and walls |
| `src/UnionFind/UnionFind.java` | Union-find interface |
| `src/UnionFind/UnionFindInArray.java` | Array-backed implementation with path compression |
| `src/UnionFind/*Exception.java` | Domain exceptions for invalid operations |
| `Can Rob Escape.pdf` | Original assignment statement |
