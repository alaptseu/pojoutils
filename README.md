# pojoutils
The idea is to impplement generic builder that is capable of building every POJO with a default constructor.

Example:

`RecordDTO value = GenericBuilder.of(RecordDTO::new)
            .with(RecordDTO::setFirstName, "Otto").with(RecordDTO::setLastName, "Ottos").build();  
`  

Stop writing boilerplate builder patterns and get productive using the GenericBuilder/PredicateBuilder