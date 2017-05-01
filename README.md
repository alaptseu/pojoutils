# pojoutils
The idea is to impplement generic builder that is capable of building every POJO with a default constructor.

Example:

`RecordDTO value = GenericBuilder.of(RecordDTO::new)
            .with(RecordDTO::setFirstName, "Otto").with(RecordDTO::setLastName, "Ottos").build();  
`  

Stop writing boilerplate builder patterns and get productive using the GenericBuilder/PredicateBuilder

You can integrate pojoutils by adding the following dependency in your pom.xml (only SNAPSHOT is available as for now)

```xml
<repositories>
  <repository>
     <id>oss.snapshots</id>
     <name>OSS Sonatype Snapshot Repository</name>
      <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
      <releases>
       <enabled>false</enabled>
      </releases>
      <snapshots>
       <enabled>true</enabled>
      </snapshots>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.alaptseu</groupId>
  <artifactId>pojoutils</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```