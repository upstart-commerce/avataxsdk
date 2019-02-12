# Avatax Client

Pure Scala library for interaction with Avatax APIs.

Project is split into following modules:

- core - Zero-dependency project - Scala ADT of data transfer objects. Based on docs & [official sdk](https://github.com/avadev/AvaTax-REST-V2-JRE-SDK).
- client - akka-http + play-json client for AvaTax

### Installation

Add following to your build.sbt
```
libraryDependencies += "TODO"
```

### Compilation

First compilation will take a long time (>10minutes) due to huge amount of data types available and following json format macros. Followup incremental compilations should be
fast.