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

# Liskov Substitution Principle (LSP) Solution

## Problem Identification
The original code violated the Liskov Substitution Principle in the following ways:

1. `ElectronicDuck` inherits from `Duck` but cannot fulfill the base class contract:
   - It cannot be substituted for `Duck` without breaking the application

2. The `Pool` class assumes all ducks can swim and quack at any time, which isn't true for electronic ducks

## Solution
The code was refactored to:

1. Create an interface for the basic duck behavior
2. Separate the power-dependent behavior into a separate interface
3. Make electronic duck implement both interfaces
4. Update the Pool class to work with the correct abstraction level

This ensures that any type of duck can be safely substituted where its interface is expected.

# Interface Segregation Principle (ISP) Solution

## Problem Identification
The original code violated the Interface Segregation Principle in the following ways:

1. The `Door` interface was too broad, containing methods for multiple responsibilities:
   - Basic door operations (lock, unlock, open, close)
   - Timer callbacks (timeOutCallback)
   - Proximity sensor callbacks (proximityCallback)

2. Classes were forced to implement methods they didn't use:
   - `SensingDoor` had to implement `timeOutCallback` with an exception
   - `TimedDoor` had to implement `proximityCallback` with an exception

## Solution
The code was refactored by splitting the `Door` interface into smaller, more focused interfaces:

1. `Door` - Basic door operations
2. `TimerClient` - Timer callback functionality
3. `ProximitySensor` - Proximity sensor functionality

This ensures that classes only need to implement the interfaces relevant to their behavior.

# Dependency Inversion Principle (DIP) Solution

## Problem Identification
The original code violated the Dependency Inversion Principle in the following ways:

1. The `EncodingModule` class had direct dependencies on concrete implementations:
   - File I/O classes (FileReader, FileWriter)
   - Network classes (URL, InputStream)
   - Database class (MyDatabase)

2. The class was tightly coupled to:
   - Specific file paths
   - Network protocols and URLs
   - Database implementation

## Solution
The code was refactored to:

1. Create abstractions for:
   - Reading and writing data
   - Database operations
2. Make the `EncodingModule` depend on these abstractions
3. Implement concrete classes for different data sources
4. Use dependency injection to provide the concrete implementations

This removes dependency on concrete implementations
