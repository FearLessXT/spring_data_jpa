<h1 align="center">Hi 👋, I'm Raksmey</h1>
<h3 align="center">A Software Engineer from Cambodia living in Phnom Penh City</h3>

<h3 align="left">Connect with me:</h3>
<p align="left">
<a href="https://www.linkedin.com/in/munyraksmey-mang-a060071bb" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="bouali-ali-33026072" height="30" width="40" /></a>

<h3 align="center">The Complete Spring Data JPA</h3>
<h4>Learn Spring data JPA from basic to advance</h3>

```mermaid
graph TD
    SDK["OpenTelemetry SDK"] --> |HTTP or gRPC| COLLECTOR
    COLLECTOR["Jaeger Collector"] --> STORE[Storage]
    COLLECTOR --> |gRPC| PLUGIN[Storage Plugin]
    COLLECTOR --> |gRPC/sampling| SDK
    PLUGIN --> STORE
    QUERY[Jaeger Query Service] --> STORE
    QUERY --> |gRPC| PLUGIN
    UI[Jaeger UI] --> |HTTP| QUERY
    subgraph Application Host
        subgraph User Application
            SDK
        end
    end
```
