package Homework_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void testNegativeNumber() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> triangle.triangleArea(-10,20, 30));
        logger.info("Тест на ввод отрицательных чисел");
    }
    @Test
    void testZeroNumber() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> triangle.triangleArea(10,0, 30));
        logger.info("Тест на ввод нуля");
    }
    @Test
    void testCantFormTriangle() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> triangle.triangleArea(10,12, 56));
        logger.info("Тест на ввод чисел, из которых нельзя сформировать треугольник");
    }

    @ParameterizedTest
    @CsvSource({ "7,4,5, 9.797958971132712","15, 8, 9, 29.93325909419153", "3, 2, 4, 2.9047375096555625"})
    void testWithCsvSourcePos(int a, int b, int c, double result) throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(result,triangle.triangleArea(a,b,c));

    }

    @ParameterizedTest
    @CsvSource({ "-10,20, 30","0, 8, 9","66, 2, 4"})
    void testWithCsvSourceNeg(int a, int b, int c) throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> triangle.triangleArea(a,b,c));

    }
}
