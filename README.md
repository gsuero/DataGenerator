# DataGenerator

```text
TODO:
1. String transformers: uppercase, capitalize, lowercase, substring, concatenate
2. Implement SOURCED_STRING:
3. Add Writers (CSV, JSON, SQL) with interface and ExportType
```

###Usage
```java
        new ProducerBuilder(150) // 150 rows
                    .fileName("data.csv")
                    .columns(Map<String, BaseColumn>()) 
                    .build()
                    .produce();
```