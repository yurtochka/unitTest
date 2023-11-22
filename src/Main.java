import java.util.List;

import static org.mockito.Mockito.*;

public class Main {
    public static void main(String[] args){
        //создание mock
        List mockedList = mock(List.class);

        //Использование
        mockedList.add("one");
        mockedList.clear();
    }
}
