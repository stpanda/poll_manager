package com.example.poll.convertservice;

/**
 * Converter is an interface describing a Java class, that can perform S-to-T conversions. S-to-T conversion is a
 * conversion between object of type S to an object of type T. T object is a representation of S object, that carries
 * data between processes.
 *
 * @param <S> the type of source object
 * @param <T> the type of object, obtained as a result of conversion
 */
public interface Converter<S, T> {
    /**
     * Method, that converts an object of type S into an object of type T.
     *
     * @param source the object to be converted
     * @return the object, obtained as a result of conversion
     */
    T convert(S source);

    /**
     * Method that returns the runtime class of the object being converted.
     *
     * @return the runtime class of the object being converted
     */
    Class<S> getSource();

    /**
     * A method that returns the runtime class of an object, which obtained as a result of conversion.
     *
     * @return the runtime class of an object, which obtained as a result of conversion
     */
    Class<T> getTarget();
}
