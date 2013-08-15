springcustomeditorreferencingabean
==================================

A sample how to implement a custom propertyeditor for Spring 2.x which allows you to configure bean references with string literals.
The propertyeditor tries to resolve the referenced beans given by their id.

Example

```
    <bean id="foo" class="com.sample.Foo">
        <property name="list" value="barA,barB"/>
    </bean>
    
    <bean id="barA" class="com.sample.Bar"/>
    <bean id="barB" class="com.sample.Bar"/>
```
