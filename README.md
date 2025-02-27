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
![SRP](https://www.plantuml.com/plantuml/png/XL11QiCm4Bph5NjCAFw0AI5DGi3Gb9AyO1sfnbIIYrOvXDA_Ly8HAncL-cJDpkpEp9OyEdyp6YxdTt7LI0HxTF0j87mDZ19Qk7Wtsk61c4aglGHxXtR1V891-KwkrXNu57TK9pk7jj3y27Prd9n1xrMmnug0lw5HjBgYenPUH_BF0TlyiUE45WV50OFghBuc6ltaxa6opz_CuTDjuIJRWlPp7gT_zdXqapdqqM4dawlrJ2s2q9oaMeoYo5WbMSh4vxWKPYywgOavRTu97Nh8X8_D7wELktid_qdoedKC4xtoYdWqwxzfDkNrof1RNiouOcRnIAGn8sNEX8gjil9cjFW5)
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

![OCP](https://www.plantuml.com/plantuml/png/rPB1IiGm48RlUOevhaXVO0-oQriX85PQzLh698LWsaWo5KLyTsDR1aeBNZMt3F_CVF_Fd29XeB5tKENt0fyZ1LG4oc6CK9lenw0CV0f8BmEhuGXseEbx2UYSLqZcSB4gTy7CfJTlzLBhCRnSZ_7Z49QPKayjExARrFwBhBE3_f7nuYyXriZd6Sq7PfTtJ-TRMRHrsLIFTLwsijWrmwkFF6nZRq_4YCpIlA8oZVF4EPftCeFU1Fidatom_N-4tnv0bbqnin2dv26Tk_W6)

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

![LSP](https://www.plantuml.com/plantuml/png/hP5FIiOm4CNtEKMMYlO2tq8gr8KWMEW192PJ24qccapQXNXt-oSbZNIXy7NNnvitxpUf0mbFqHh-qhLC8u7lXGJ-t4Gvy2_6v-_kCmevtDpo2n-TLfiM9cspzCsEiwsRm8DgODGIzX2A7bynZsInxt-fEYJZktC612xnqeWG-DfAsmy35f32_skcd2S3ahn3BKyJxyyPgZU7kTLVbrw3FjLkPsMdzR6CIrKUKNNBUZLZN3QQqgN0EWpa1K5YN3p9NzxbUBTrTLKzh4-G_ye1LWEgQ0tx0G00https://www.plantuml.com/plantuml/png/hP5FIiOm4CNtEKMMYlO2tq8gr8KWMEW192PJ24qccapQXNXt-oSbZNIXy7NNnvitxpUf0mbFqHh-qhLC8u7lXGJ-t4Gvy2_6v-_kCmevtDpo2n-TLfiM9cspzCsEiwsRm8DgODGIzX2A7bynZsInxt-fEYJZktC612xnqeWG-DfAsmy35f32_skcd2S3ahn3BKyJxyyPgZU7kTLVbrw3FjLkPsMdzR6CIrKUKNNBUZLZN3QQqgN0EWpa1K5YN3p9NzxbUBTrTLKzh4-G_ye1LWEgQ0tx0G00)

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

![ISP](https://www.plantuml.com/plantuml/png/jLAnReCm5Dpz5MyaIlW13rKasY535QJGENBW5Lcr_P1jgbPL_xrWI709LQIgPJnqT-_kl7LUMDzg1Rj33amQZ_PPb0ZtH1O-67JVMb7vago0mol9Qe1Qim1IWsO6bOeSJjWdYonoIszII_z-GECcj-OCPqAfamWkI_H2QhIPacZycUexQD_wHMAfX7FGMqbJXtHIDmfrHtSXxUQ7Wz9Z7nKhu70YKYZC2FTnh-1rv92ueCDXq5lzTPktwufIJmLRhANpE9qto_rDFvKkH-l8P8Ft5FSY7vQebYkDH_fDdMcnUtmuxf-A3k-c7m9S_1BVo_FWya_rtdvImVogsv77GP6fDr262dZSHwp4neNIz6w-1WkKy2SYiosQgjMAVG40)

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

![DIP](https://www.plantuml.com/plantuml/png/bPB1JW8n48RlVOeUQmGUW1128ffmm10zU336rEs0ZQLBkhCIexwxBMsN3ja4t5jdlfb__jcPDIWTjbl3vuiLqnR1hMK5VF40Ke7ZtupxxzhvbxZYO_w8JjiD-sKb--Gq7jbzU0abKMOy57xMMeMooiYcuNVQ054Ohdra9V6zquZDZg38HDUrTpIgaISxev71VetBBDq3xcltGLsrpfo84Kpu_ALsbbzph_yc6yZDNyD0dbpAtMHX4JRW1gbiceYgRYrwH5iidMYxQp6IdNoYEhsiHbUeKdHSp1CxKrxqWV_OvgsjQkKporgrfdFi3biRv-kCmKEx48pAKOFMYvF20JyfIfD1g09nRfmRey5YllUjr5P8jscoc-UNia6Iv9EVqQYuUnedLy7IKCUI-APnkc_6w9iFXzFo5r438PjtqPjAJNjj1u0cs0oiQhU6_G40)

The code was refactored to:

1. Create abstractions for:
   - Reading and writing data
   - Database operations
2. Make the `EncodingModule` depend on these abstractions
3. Implement concrete classes for different data sources
4. Use dependency injection to provide the concrete implementations

This removes dependency on concrete implementations
