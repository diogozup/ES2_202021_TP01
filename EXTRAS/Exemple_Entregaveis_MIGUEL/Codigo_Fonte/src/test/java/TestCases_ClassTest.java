import implementation.models.Question;
import implementation.models.QuestionMultipleChoice;
import implementation.models.QuestionNumeric;
import implementation.models.QuestionYesNo;
import interfaces.controller.ITest;
import interfaces.controller.ITestStatistics;
import interfaces.exceptions.QuestionException;
import interfaces.exceptions.TestException;
import interfaces.models.IQuestion;
import interfaces.models.IQuestionNumeric;
import interfaces.models.IQuestionYesNo;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases_ClassTest {

    ITest demoTest;
    ITestStatistics demoTestStatistics;
    QuestionYesNo q1;
    IQuestion[] arrayIQuestions = new IQuestion[100];

    @BeforeEach
    public void init() throws TestException {
        demoTest = new implementation.controller.Test();
        // demoTest.loadFromJSONFile("data/teste_A.json");
        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
    }

    // MÉTODO ADDQUESTION()

    @Test
    @DisplayName("AQ_01")
    public void Teste_AQ_01() {

        demoTest = new implementation.controller.Test();
        QuestionYesNo q = null;

        assertThrows(TestException.class, () -> {
            demoTest.addQuestion(q);
        }, "Devia de dar TestException");
    }

    @Test
    @DisplayName("AQ_02")
    public void Teste_AQ_02() throws TestException {

        demoTest = new implementation.controller.Test();

        for (int i = 0; i < 50; i++) {
            demoTest.addQuestion(q1);
        }

        assertTrue(demoTest.addQuestion(q1), "Era suposto ter adicionado.");
    }

    @Test
    @DisplayName("AQ_03")
    public void Teste_AQ_03() throws TestException {

        demoTest = new implementation.controller.Test();

        for (int i = 0; i < 100; i++) {
            demoTest.addQuestion(q1);
        }

        assertFalse(demoTest.addQuestion(q1),
                "Era suposto ter dado não ter adicionado devido ao limite de 100 questões");

    }

    @Test
    @DisplayName("AQ_04")
    public void Teste_AQ_04() throws TestException {

        demoTest = new implementation.controller.Test();

        assertTrue(demoTest.addQuestion(q1), "Era suposto ter adicionado na primeira posição");

    }

    @Test
    @DisplayName("AQ_05")
    public void Teste_AQ_05() throws TestException {

        demoTest = new implementation.controller.Test();
        demoTest.addQuestion(q1);

        assertTrue(demoTest.addQuestion(q1), "Era suposto ter adicionado na segunda posição");

    }

    @Test
    @DisplayName("AQ_06")
    public void Teste_AQ_06() throws TestException {

        demoTest = new implementation.controller.Test();

        for (int i = 0; i < 98; i++) {
            demoTest.addQuestion(q1);
        }

        assertTrue(demoTest.addQuestion(q1), "Era suposto ter adicionado a 99º questão");

    }

    @Test
    @DisplayName("AQ_07")
    public void Teste_AQ_07() throws TestException {

        demoTest = new implementation.controller.Test();

        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
        }

        assertTrue(demoTest.addQuestion(q1), "Era suposto ter adicionado a 99º questão");

    }

    // MÉTODO REMOVEQUESTION()

    @Test
    @DisplayName("RQ_01")
    public void Teste_RQ_01() throws TestException {

        demoTest = new implementation.controller.Test();

        for (int i = 0; i < 50; i++) {
            demoTest.addQuestion(q1);
        }

        assertTrue(demoTest.removeQuestion(49), "Era suposto ter removido a 50º questão");

        assertNull(demoTest.getQuestion(49), "A posição devia de estar a null!");
    }

    @Test
    @DisplayName("RQ_02")
    public void Teste_RQ_02() throws TestException {

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> demoTest.removeQuestion(100),
                "Devia de dar a exceção ArrayIndexOutOfBoundsException");

    }

    @Test
    @DisplayName("RQ_03")
    public void Teste_RQ_03() throws TestException {

        demoTest = new implementation.controller.Test();

        assertFalse(demoTest.removeQuestion(49), "Era suposto ter retornado false");
    }

    @Test
    @DisplayName("RQ_04")
    public void Teste_RQ_04() throws TestException {

        demoTest = new implementation.controller.Test();

        demoTest.addQuestion(q1);

        assertTrue(demoTest.removeQuestion(0), "Era suposto ter removido e retornado true!");
    }

    @Test
    @DisplayName("RQ_05")
    public void Teste_RQ_05() throws TestException {

        demoTest = new implementation.controller.Test();

        demoTest.addQuestion(q1);
        demoTest.addQuestion(q1);

        assertTrue(demoTest.removeQuestion(1), "Era suposto ter removido e retornado true!");
    }

    @Test
    @DisplayName("RQ_06")
    public void Teste_RQ_06() throws TestException {

        demoTest = new implementation.controller.Test();

        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
        }

        assertTrue(demoTest.removeQuestion(98), "Era suposto ter removido e retornado true!");
    }

    @Test
    @DisplayName("RQ_07")
    public void Teste_RQ_07() throws TestException {

        demoTest = new implementation.controller.Test();

        for (int i = 0; i < 100; i++) {
            demoTest.addQuestion(q1);
        }

        assertTrue(demoTest.removeQuestion(99), "Era suposto ter removido e retornado true!");
    }

    @Test
    @DisplayName("RQ_08")
    public void Teste_RQ_08() throws TestException {

        demoTest = new implementation.controller.Test();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> demoTest.removeQuestion(-1),
                "Devia de dar a exceção ArrayIndexOutOfBoundsException");
    }

    // MÉTODO NUMBERQUESTIONS()

    @org.junit.jupiter.api.Test
    @DisplayName("NQ_02")
    public void teste_nq_02() throws TestException {
        for (int i = 0; i < 102; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
            demoTest.addQuestion(questionNumeric);
        }
        assertEquals(101, demoTest.numberQuestions());
    }
    /*
     * @org.junit.jupiter.api.Test
     * 
     * @DisplayName("NQ_03") public void teste_nq_03() { assertEquals(0,
     * demoTest.numberQuestions(1,2)); }
     */

    @org.junit.jupiter.api.Test
    @DisplayName("NQ_04")
    public void teste_nq_04() {
        assertEquals(0, demoTest.numberQuestions());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("NQ_05")
    public void teste_nq_05() throws TestException {
        IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
        demoTest.addQuestion(questionNumeric);
        assertEquals(1, demoTest.numberQuestions());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("NQ_06")
    public void teste_nq_06() throws TestException {
        for (int i = 0; i <= 49; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
            demoTest.addQuestion(questionNumeric);
        }
        assertEquals(50, demoTest.numberQuestions());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("NQ_07")
    public void teste_nq_07() throws TestException {
        for (int i = 0; i <= 98; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
            demoTest.addQuestion(questionNumeric);
        }
        assertEquals(99, demoTest.numberQuestions());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("NQ_08")
    public void teste_nq_08() throws TestException {
        for (int i = 0; i <= 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
            demoTest.addQuestion(questionNumeric);
        }
        assertEquals(100, demoTest.numberQuestions());
    }

    // MÉTODO ISCOMPLETE()

    /*
     * @org.junit.jupiter.api.Test
     * 
     * @DisplayName("IC_01") public void ic01() throws TestException {
     * assertTrue(demoTest.isComplete(1,2)); }
     */

    @org.junit.jupiter.api.Test
    @DisplayName("IC_02")
    public void ic2() throws TestException {
        for (int i = 0; i < 11; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
            demoTest.addQuestion(questionNumeric);
        }
        assertFalse(demoTest.isComplete());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("IC_03")
    public void ic03() throws TestException {
        for (int i = 0; i < 11; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i < 1; i++) {
            demoTest.getQuestion(0).setDone(true);
        }
        assertFalse(demoTest.isComplete());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("IC_04")
    public void ic04() throws TestException {
        for (int i = 0; i < 11; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i < 6; i++) {
            demoTest.getQuestion(i).setDone(true);
        }
        assertFalse(demoTest.isComplete());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("IC_05")
    public void ic05() throws TestException {
        for (int i = 0; i < 11; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i < 10; i++) {
            demoTest.getQuestion(i).setDone(true);
        }
        assertFalse(demoTest.isComplete());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("IC_06")
    public void ic06() throws TestException {
        for (int i = 0; i < 11; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Soma", "2+2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i < 11; i++) {
            demoTest.getQuestion(i).setDone(true);
        }
        assertTrue(demoTest.isComplete());
    }

}
