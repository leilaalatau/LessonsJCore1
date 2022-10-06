package lessonsJCore.JCore.dz.lesson3task1;

public class SwapArrayClass<T> {
    T intermediate;

    public T[] swapElements(T[] array, int indexA, int indexB){
        intermediate = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = intermediate;
        return array;
    }
}
