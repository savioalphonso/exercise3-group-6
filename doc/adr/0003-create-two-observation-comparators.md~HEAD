# 3. Create Two Observation Comparators

Date: 2020-10-07

## Status

Accepted

## Context

Whale observations have a variety of qualities and may require sorting for research purposes. Two
distinct sorting methods proposed for sorting these observations will require two unique comparators.
The comparators must be implemented using one of three possible comparator designs: nested classes, 
anonymous classes, and lambda expressions.

## Decision

Create two nested comparator classes within the Observation class for `x` and `y`. 

## Consequences

The nested comparator class is the best choice for the program due to the reusability in future
iterations of the program, versus the one-use nature of anonymous classes and lambda expressions.
Additional `compareTo` method implemented for proper function of `Comparable<Observation>` in 
Observation class.