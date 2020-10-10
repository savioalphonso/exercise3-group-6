# Make Repository Iterable

Date: 2020-10-08

## Status

Accepted

## Context

ObservationRepository and WhaleRepository both implement `Iterable<T>` to enable searching in their
respective lists. Since ObservationRepository and WhaleRepository both implement `Repository<T>`
it may make sense to implement `Iterable<T>` in Repository rather than it's subclasses.

## Decision

Implement `Iterable<T>` in Repository and remove `Iterable<T>` from ObservationRepository
and WhaleRepository.

## Consequences

Current and future subclasses of Repository will have `Iterable<T>` built in.