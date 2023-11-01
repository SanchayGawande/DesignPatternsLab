package edu.umb.cs680.Hw05;

public interface Observer<T> {
    void update(Observable<T> sender, T event);
}
