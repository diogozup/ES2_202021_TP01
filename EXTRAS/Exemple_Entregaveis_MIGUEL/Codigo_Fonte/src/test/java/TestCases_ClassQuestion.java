import implementation.models.Question;
import implementation.models.QuestionMultipleChoice;
import implementation.models.QuestionNumeric;
import implementation.models.QuestionYesNo;
import interfaces.controller.ITest;
import interfaces.controller.ITestStatistics;
import interfaces.exceptions.QuestionException;
import interfaces.exceptions.TestException;
import interfaces.models.IQuestion;
import interfaces.models.IQuestionYesNo;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases_ClassQuestion {

    ITest demoTest;
    ITestStatistics demoTestStatistics;
    QuestionYesNo q1;
    IQuestion[] arrayIQuestions = new IQuestion[100];

    @BeforeEach
    public void init() throws TestException {
        demoTest = new implementation.controller.Test();
        demoTest.loadFromJSONFile("data/teste_A.json");
        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
    }

    //MÉTODO EVALUATEANSWERS()

    @Test
    @DisplayName("Teste_EA_01")
    public void Teste_EA_01() throws TestException {

        IQuestion question = demoTest.getQuestion(0);
        question.answer(null);

        assertThrows(Throwable.class, () -> {
            question.evaluateAnswer();
        }, "O utilizador respondeu " + ((QuestionMultipleChoice) question).getUser_answer() + " mas o resultado e: " + ((QuestionMultipleChoice) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_02")
    public void Teste_EA_02() throws TestException {

        IQuestion question = demoTest.getQuestion(2);
        question.answer("no");

        assertTrue(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionYesNo) question).getUser_answer() + " mas o resultado e: " + ((QuestionYesNo) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_03")
    public void Teste_EA_03() throws TestException {

        IQuestion question = demoTest.getQuestion(3);
        question.answer("2");

        assertFalse(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionNumeric) question).getUser_answer() + " mas o resultado e: " + ((QuestionNumeric) question).getCorrect_anwser());
    }

    @Test
    @DisplayName("Teste_EA_04")
    public void Teste_EA_04() throws TestException {

        IQuestion question = demoTest.getQuestion(0);
        question.answer("");

        assertThrows(Throwable.class, () -> {
            question.evaluateAnswer();
        }, "O utilizador respondeu " + ((QuestionMultipleChoice) question).getUser_answer() + " mas o resultado e: " + ((QuestionMultipleChoice) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_05")
    public void Teste_EA_05() throws TestException {

        IQuestion question = demoTest.getQuestion(4);
        question.answer("");

        assertThrows(TestException.class, () -> {
            question.evaluateAnswer();
        }, "O utilizador respondeu " + ((QuestionNumeric) question).getUser_answer() + " mas o resultado e: " + ((QuestionNumeric) question).getCorrect_anwser());
    }

    @Test
    @DisplayName("Teste_Teste_EA_06")
    public void Teste_Teste_EA_06() throws TestException {

        IQuestion question = demoTest.getQuestion(5);
        question.answer("a");

        assertTrue(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionMultipleChoice) question).getUser_answer() + " mas o resultado e: " + ((QuestionMultipleChoice) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_07")
    public void Teste_EA_07() throws TestException {

        IQuestion question = demoTest.getQuestion(5);
        question.answer("A");

        assertTrue(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionMultipleChoice) question).getUser_answer() + " mas o resultado e: " + ((QuestionMultipleChoice) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_08")
    public void Teste_EA_08() throws TestException {

        IQuestion question = demoTest.getQuestion(7);
        question.answer("abcdefghijklmnopqrstvxyz");

        assertTrue(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionMultipleChoice) question).getUser_answer() + " mas o resultado e: " + ((QuestionMultipleChoice) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_09")
    public void Teste_EA_09() throws TestException {

        IQuestion question = demoTest.getQuestion(6);
        question.answer("0");

        assertTrue(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionNumeric) question).getUser_answer() + " mas o resultado e: " + ((QuestionNumeric) question).getCorrect_anwser());
    }

    @Test
    @DisplayName("Teste_EA_10")
    public void Teste_EA_10() throws TestException {

        IQuestion question = demoTest.getQuestion(3);
        question.answer("1");

        ((QuestionNumeric) question).setCorrect_anwser(1);

        assertTrue(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionNumeric) question).getUser_answer() + " mas o resultado e: " + ((QuestionNumeric) question).getCorrect_anwser());
    }

    @Test
    @DisplayName("Teste_EA_11")
    public void Teste_EA_11() throws TestException {

        IQuestion question = demoTest.getQuestion(8);
        question.answer("2147483647");

        ((QuestionNumeric) question).setCorrect_anwser(2147483647);

        assertTrue(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionNumeric) question).getUser_answer() + " mas o resultado e: " + ((QuestionNumeric) question).getCorrect_anwser());
    }

    @Test
    @DisplayName("Teste_EA_12")
    public void Teste_EA_12() throws TestException {

        IQuestion question = demoTest.getQuestion(2);
        question.answer("NO");

        assertTrue(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionYesNo) question).getUser_answer() + " mas o resultado e: " + ((QuestionYesNo) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_13")
    public void Teste_EA_13() throws TestException {

        IQuestion question = demoTest.getQuestion(5);
        question.answer("b");

        assertFalse(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionMultipleChoice) question).getUser_answer() + " mas o resultado e: " + ((QuestionMultipleChoice) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_14")
    public void Teste_EA_14() throws TestException {

        IQuestion question = demoTest.getQuestion(5);
        question.answer("B");

        assertFalse(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionMultipleChoice) question).getUser_answer() + " mas o resultado e: " + ((QuestionMultipleChoice) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_15")
    public void Teste_EA_15() throws TestException {

        IQuestion question = demoTest.getQuestion(7);
        question.answer("abcdefghijklmnopqrstvxy");

        assertFalse(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionMultipleChoice) question).getUser_answer() + " mas o resultado e: " + ((QuestionMultipleChoice) question).getCorrect_answer());
    }

    @Test
    @DisplayName("Teste_EA_16")
    public void Teste_EA_16() throws TestException {

        IQuestion question = demoTest.getQuestion(3);
        question.answer("0");

        ((QuestionNumeric) question).setCorrect_anwser(1);

        assertFalse(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionNumeric) question).getUser_answer() + " mas o resultado e: " + ((QuestionNumeric) question).getCorrect_anwser());
    }

    @Test
    @DisplayName("Teste_EA_17")
    public void Teste_EA_17() throws TestException {

        IQuestion question = demoTest.getQuestion(8);
        question.answer("2147483646");

        ((QuestionNumeric) question).setCorrect_anwser(2147483647);

        assertFalse(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionNumeric) question).getUser_answer() + " mas o resultado e: " + ((QuestionNumeric) question).getCorrect_anwser());
    }

    @Test
    @DisplayName("Teste_EA_18")
    public void Teste_EA_18() throws TestException {

        IQuestion question = demoTest.getQuestion(2);
        question.answer("YES");

        assertFalse(question.evaluateAnswer(), "O utilizador respondeu " + ((QuestionYesNo) question).getUser_answer() + " mas o resultado e: " + ((QuestionYesNo) question).getCorrect_answer());
    }



    //MÉTODO ANSWER()


    //Teste à exceção das questões numéricas, resposta a vazia ("")
    //Teste se resposta passa a done através do método isDone()
    @Test
    @DisplayName("A1")
    public void A1() throws TestException {

        QuestionNumeric qn = new QuestionNumeric(4.0,"Soma","2 + 2");
        demoTest.addQuestion(qn);

        assertThrows(QuestionException.class,()->{
            qn.answer("");
        });

        assertTrue(qn.isDone());

    }

    //Teste à exceção das questões numéricas, resposta a null
    //Teste se resposta passa a done através do método isDone()
    @Test
    @DisplayName("A2")
    public void A2() throws TestException {

        QuestionNumeric qn = new QuestionNumeric(4.0,"Soma","2 + 2");
        demoTest.addQuestion(qn);

        assertThrows(QuestionException.class,()->{
            qn.answer(null);
        });

        assertTrue(qn.isDone());

    }

    //Teste à resposta yes ou no, com resposta em maiúsculas
    //Teste se resposta passa a done através do método isDone()
    @Test
    @DisplayName("A3")
    public void A3() throws TestException {

        QuestionYesNo qyn = new QuestionYesNo("YesNo","Sim ou nao");

        qyn.setCorrect_answer("yes");

        demoTest.addQuestion(qyn);

        qyn.answer("YES");

        assertAll(() -> { assertEquals("yes", qyn.getUser_answer());
        assertTrue(qyn.isDone());
        });

    }

    //Teste à resposta yes ou no, com resposta em maiúsculas
    //Teste se resposta passa a done através do método isDone()
    @Test
    @DisplayName("A4")
    public void A4() throws TestException {

        QuestionYesNo qyn = new QuestionYesNo("YesNo","Sim ou nao");

        qyn.setCorrect_answer("no");

        demoTest.addQuestion(qyn);

        qyn.answer("NO");

        assertAll(() -> {
            assertEquals("no", qyn.getUser_answer());
            assertTrue(qyn.isDone());
        });

    }

    //Teste à resposta yes ou no, com resposta em minúsculas
    //Teste se resposta passa a done através do método isDone()
    @Test
    @DisplayName("A5")
    public void A5() throws TestException {

        QuestionYesNo qyn = new QuestionYesNo("YesNo","Sim ou nao");

        qyn.setCorrect_answer("yes");

        demoTest.addQuestion(qyn);

        qyn.answer("yes");

        assertAll(() -> {
            assertEquals("yes", qyn.getUser_answer());
            assertTrue(qyn.isDone());
        });

    }

    //Teste à resposta yes ou no, com resposta em minúsculas
    //Teste se resposta passa a done através do método isDone()
    @Test
    @DisplayName("A6")
    public void A6() throws TestException {

        QuestionYesNo qyn = new QuestionYesNo("YesNo","Sim ou nao");

        qyn.setCorrect_answer("no");

        demoTest.addQuestion(qyn);

        qyn.answer("no");

        assertAll(() -> {
            assertEquals("no", qyn.getUser_answer());
            assertTrue(qyn.isDone());
        });

    }

    //Teste à resposta yes ou no, com um valor inteiro
    //Teste se resposta passa a done através do método isDone()
    /*
    @Test
    @DisplayName("A7")
    public void A7() throws TestException {

        QuestionYesNo qyn = new QuestionYesNo("YesNo","Sim ou nao");

        qyn.setCorrect_answer("no");

        demoTest.addQuestion(qyn);

        qyn.answer(2);

        assertAll(() -> {
            assertEquals(2, qyn.getUser_answer());
            assertTrue(qyn.isDone());
        });

    }*/


    @Test
    @DisplayName("A8")
    public void A8() throws TestException {

        Double d = -Double.MAX_VALUE;


        System.out.println(-d + " ------- Double.MIN_VALUE");

        QuestionNumeric qn = new QuestionNumeric(d-1,"YesNo","Sim ou nao");

        demoTest.addQuestion(qn);


        qn.answer(Double.toString(d-1));//"-4.9E-324"
        assertAll(() -> {
            assertEquals(-Double.MAX_VALUE-1, qn.getUser_answer());
            assertTrue(qn.isDone());
        });
    }

    @Test
    @DisplayName("A9")
    public void A9() throws TestException {

        Double d = -Double.MAX_VALUE;

        System.out.println(d + " ------- ");

        QuestionNumeric qn = new QuestionNumeric(d,"YesNo","Sim ou nao");

        //qyn.setCorrect_answer("no");
        String resposta = Double.toString(d);

        System.out.println(resposta + " ******* ");

        demoTest.addQuestion(qn);

        qn.answer(Double.toString(d));//"-4.9E-324");
        assertAll(() -> {
            assertEquals(d, qn.getUser_answer());
            assertTrue(qn.isDone());
        });
    }

    @Test
    @DisplayName("A10")
    public void A10() throws TestException {

        Double d = -Double.MAX_VALUE;

        System.out.println(d + " ------- ");

        QuestionNumeric qn = new QuestionNumeric(d+1,"YesNo","Sim ou nao");

        //qyn.setCorrect_answer("no");
        String resposta = Double.toString(d);

        System.out.println(resposta + " ******* ");

        demoTest.addQuestion(qn);

        qn.answer(Double.toString(d+1));//"-4.9E-324");
        assertAll(() -> {
            assertEquals(-Double.MAX_VALUE+1, qn.getUser_answer());
            assertTrue(qn.isDone());
        });
    }

    @Test
    @DisplayName("A11")
    public void A11() throws TestException {

        Double d = Double.MAX_VALUE;

        System.out.println(d + " ------- ");

        QuestionNumeric qn = new QuestionNumeric(d-1,"YesNo","Sim ou nao");

        //qyn.setCorrect_answer("no");
        String resposta = Double.toString(d);

        System.out.println(resposta + " ******* ");

        demoTest.addQuestion(qn);

        qn.answer(Double.toString(d-1));//"4.9E-324");
        assertAll(() -> {
            assertEquals(Double.MAX_VALUE-1, qn.getUser_answer());
            assertTrue(qn.isDone());
        });
    }

    @Test
    @DisplayName("A12")
    public void A12() throws TestException {

        Double d = Double.MAX_VALUE;

        System.out.println(d + " ------- ");

        QuestionNumeric qn = new QuestionNumeric(d,"YesNo","Sim ou nao");

        //qyn.setCorrect_answer("no");
        String resposta = Double.toString(d);

        System.out.println(resposta + " ******* ");

        demoTest.addQuestion(qn);

        qn.answer(Double.toString(d));//"4.9E-324");
        assertAll(() -> {
            assertEquals(Double.MAX_VALUE, qn.getUser_answer());
            assertTrue(qn.isDone());
        });
    }

    @Test
    @DisplayName("A13")
    public void A13() throws TestException {

        Double d = Double.MAX_VALUE;

        System.out.println(d + " ------- ");

        QuestionNumeric qn = new QuestionNumeric(d+1,"YesNo","Sim ou nao");

        //qyn.setCorrect_answer("no");
        String resposta = Double.toString(d);

        System.out.println(resposta + " ******* ");

        demoTest.addQuestion(qn);

        qn.answer(Double.toString(d+1));//"4.9E-324");
        assertAll(() -> {
            assertEquals(Double.MAX_VALUE+1, qn.getUser_answer());
            assertTrue(qn.isDone());
        });
    }




    //Teste protegido pela linguagem
/*    @Test
    @DisplayName("A14")
    public void A14() throws TestException {

        QuestionNumeric qn = new QuestionNumeric("palavra","YesNo","Sim ou nao");

        //qyn.setCorrect_answer("no");

        demoTest.addQuestion(qn);

        qn.answer("palavra");
        assertAll(() -> {
            assertEquals("palavra", qn.getUser_answer());
            assertTrue(qn.isDone());
        });
    }*/

    //Teste à resposta de multipla escolha
    //Teste se resposta passa a done através do método isDone()
    @Test
    @DisplayName("A15")
    public void A15() throws TestException {

        String[] options = { "a", "b", "c", "d" };
        QuestionMultipleChoice qmc = new QuestionMultipleChoice("ME","MultiplaEscolha",options,"c");

        demoTest.addQuestion(qmc);

        qmc.answer("c");

        assertAll(() -> {
            assertEquals("c", qmc.getUser_answer());
            assertTrue(qmc.isDone());
        });

    }

    //Teste à resposta de multipla escolha com diferenças entre minusculas e maiúsculas
    //Teste se resposta passa a done através do método isDone()
    @Test
    @DisplayName("A16")
    public void A16() throws TestException {

        String[] options = { "a", "b", "c", "d" };
        QuestionMultipleChoice qmc = new QuestionMultipleChoice("ME","MultiplaEscolha",options,"c");

        demoTest.addQuestion(qmc);

        qmc.answer("C");

            assertAll(() -> {
            assertEquals("c", qmc.getUser_answer());
            assertTrue(qmc.isDone());
        });

    }

}