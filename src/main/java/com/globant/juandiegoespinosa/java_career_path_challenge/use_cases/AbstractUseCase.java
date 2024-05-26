package com.globant.juandiegoespinosa.java_career_path_challenge.use_cases;

/**
 * @author juandiego.espinosa@globant.com
 * @version May 26, 2024
 * @since 17
 */
public abstract class AbstractUseCase<T> {

    protected abstract T process();

    protected void validate() throws Exception {
    }

    public T execute() {
        try {
            validate();

            return process();
        } catch (Exception ex) {
            return null;
        }
    }
}