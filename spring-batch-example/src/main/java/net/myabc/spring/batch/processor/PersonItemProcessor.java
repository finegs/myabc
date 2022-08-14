package net.myabc.spring.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import net.myabc.spring.batch.entity.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
        return person;
    }
}
