# 1. Create Whale Comparator

Date: 2020-10-04

## Status

Accepted

## Context

There are a variety of whales with many attributes, thus it may be necessary to sort these whales into 
various different groupings. In order to sort these objects, a _function object_ must be implemented using
one of the three possible designs: nested classes, anonymous classes, and lambda expressions.

## Decision

Create a nested comparator class within the Whale class for `whaleId`. 

## Consequences

The nested comparator class is the best choice for the program due to the reusability in future
iterations of the program, versus the one-use nature of anonymous classes and lambda expressions.
Additional `compareTo` method implemented for proper function of `Comparable<Whale>` in Whale class.
