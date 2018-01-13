package com.github.xuejike.springboot.jkfaststart.domain_ext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.tuple.AnnotationValueGeneration;
import org.hibernate.tuple.GenerationTiming;
import org.hibernate.tuple.ValueGenerator;
import org.joda.time.DateTime;

public class CreationDateTimeGeneration implements AnnotationValueGeneration<CreationDateTime> {
    private ValueGenerator<?> generator;
    @Override
    public void initialize(CreationDateTime annotation, Class<?> propertyType) {
        if (DateTime.class.isAssignableFrom(propertyType)){
            generator=new ValueGenerator<DateTime>(){

                @Override
                public DateTime generateValue(Session session, Object owner) {
                    return DateTime.now();
                }
            };
        } else {
            throw new HibernateException( "Unsupported property type for generator annotation @CreationDateTime" );
        }
    }

    @Override
    public GenerationTiming getGenerationTiming() {
        return GenerationTiming.INSERT;
    }

    @Override
    public ValueGenerator<?> getValueGenerator() {
        return new ValueGenerator<DateTime>() {
            @Override
            public DateTime generateValue(Session session, Object owner) {
                return DateTime.now();
            }
        };
    }

    @Override
    public boolean referenceColumnInSql() {
        return false;
    }

    @Override
    public String getDatabaseGeneratedReferencedColumnValue() {
        return null;
    }
}
