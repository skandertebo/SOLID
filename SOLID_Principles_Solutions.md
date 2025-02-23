# Single Responsibility Principle (SRP) Solution

## Problem Identification
The original code violated the Single Responsibility Principle in the following ways:

1. The `CarManager` class had multiple responsibilities:
   - Database operations (getting cars from DB)
   - String formatting/presentation of car data
   - Business logic for finding the best car

This violates SRP because the class has multiple reasons to change:
- Changes to database operations
- Changes to how cars are displayed
- Changes to the best car selection criteria

## Solution
The code was refactored by splitting the `CarManager` class into three specialized classes:

1. `CarRepository` - Handles database operations
2. `CarFormatter` - Handles string formatting and presentation
3. `CarRanker` - Handles business logic for car comparison and selection

This separation ensures that each class has a single responsibility and a single reason to change.

# Open-Closed Principle (OCP) Solution

## Problem Identification
The original code violated the Open-Closed Principle in the following ways:

1. The `ResourceAllocator` class used switch statements to handle different resource types
2. Adding a new resource type required modifying the existing code
3. Resource allocation logic was tightly coupled with resource types

## Solution
The code was refactored to use an abstract base class and inheritance:

1. Created an abstract `Resource` class defining the contract for all resources
2. Implemented specific resource classes for each type
3. Removed switch statements and type checking
4. New resource types can be added by creating new classes without modifying existing code

This makes the code open for extension (new resource types) but closed for modification.
