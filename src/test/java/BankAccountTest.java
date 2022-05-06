import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void shouldNotBeBlockedWhenCreated() {
        BankAccount account = new BankAccount("a", "b");
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldReturnZeroAmountAfterActivation() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("RUB");
        assertEquals(new Integer(0), account.getAmount());
        assertEquals("RUB", account.getCurrency());
    }

    @Test
    public void shouldBeBlockedAfterBlockIsCalled(){
        BankAccount account = new BankAccount("a", "b");
        account.block();
        assertTrue(account.isBlocked());
    }

    @Test
    public void shouldReturnFirstNameThenSecondName(){
        BankAccount account = new BankAccount("a", "b");
        String[] names = account.getFullName();
        assertArrayEquals(new String[] {"a", "b"}, names, "Массивы не равны!");
    }

    @Test
    public void shouldReturnNullAmountWhenNotActive(){
        BankAccount account = new BankAccount("a", "b");

        // после исполнения блока ошибка попадёт в переменную exception
        final IllegalStateException exception = assertThrows(

                // класс ошибки
                IllegalStateException.class,

                // создание и переопределение экземпляра класса Executable
                new Executable() {
                    @Override
                    public void execute() {
                        // здесь блок кода, который хотим проверить
                        // при делении на 0 ожидаем ArithmeticException
                        account.getAmount();
                    }
                });
        assertEquals("Счёт не активирован.", exception.getMessage());
        assertNull(account.getCurrency());
    }
}
