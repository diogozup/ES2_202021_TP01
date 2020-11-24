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

public class TestCases_ClassTestStatistics {

    ITest demoTest;
    ITestStatistics demoTestStatistics;
    QuestionYesNo q1;
    IQuestion[] arrayIQuestions = new IQuestion[100];

    @BeforeEach
    public void init() throws TestException {
        demoTest = new implementation.controller.Test();
        //demoTest.loadFromJSONFile("data/teste_A.json");
        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
    }

    //MÉTODO CORRECTANSWERS()

    @Test
    @DisplayName("CA_01")
    public void Teste_CA_01() throws TestException {

        q1.setUser_answer("no"); //resposta correta
        for (int i = 0; i < 50; i++) {
            arrayIQuestions[i] = q1;
        }
        demoTestStatistics = new implementation.controller.TestStatistics(arrayIQuestions);

        IQuestionYesNo[] arrayQuestoesCertas = new IQuestionYesNo[50];
        for (int i = 0; i < 100; i++) {
            if (arrayIQuestions[i] != null  && ((IQuestionYesNo) (arrayIQuestions[i])).getCorrect_answer() == ((IQuestionYesNo) (arrayIQuestions[i])).getUser_answer()) {
                arrayQuestoesCertas[i] = ((IQuestionYesNo) (arrayIQuestions[i]));
            }
        }

        assertArrayEquals(arrayQuestoesCertas, demoTestStatistics.correctAnswers());
    }

    @Test
    @DisplayName("CA_02")
    public void Teste_CA_02() throws TestException {

        demoTest = new implementation.controller.Test();

        q1.setUser_answer("no"); //resposta correta

        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> {
            for (int i = 0; i < 102; i++) {
                demoTest.addQuestion(q1);
            }
            demoTest.getTestStatistics().correctAnswers();
        });
    }

    @Test
    @DisplayName("CA_03")
    public void Teste_CA_03() throws TestException {

        demoTest = new implementation.controller.Test();

        q1.setUser_answer("yes"); //resposta incorreta
        for (int i = 0; i < 100; i++) {
            demoTest.addQuestion(q1);
        }

        arrayIQuestions = new IQuestion[0];
        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().correctAnswers());
    }

    @Test
    @DisplayName("CA_04")
    public void Teste_CA_04() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[1];

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta
        demoTest.addQuestion(q1);
        arrayIQuestions[0] = q1;

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta

        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
        }

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().correctAnswers());
    }

    @Test
    @DisplayName("CA_05")
    public void Teste_CA_05() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[1];

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta
        demoTest.addQuestion(q1);

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta
        demoTest.addQuestion(q1);
        arrayIQuestions[0] = q1;

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta

        for (int i = 0; i < 98; i++) {
            demoTest.addQuestion(q1);
        }

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().correctAnswers());
    }

    @Test
    @DisplayName("CA_06")
    public void Teste_CA_06() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[1];

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta
        for (int i = 0; i < 98; i++) {
            demoTest.addQuestion(q1);
        }

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta
        demoTest.addQuestion(q1);
        arrayIQuestions[0] = q1;

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().correctAnswers());
    }

    @Test
    @DisplayName("CA_07")
    public void Teste_CA_07() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[1];

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta
        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
        }

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta
        demoTest.addQuestion(q1);
        arrayIQuestions[0] = q1;

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().correctAnswers());
    }

    @Test
    @DisplayName("CA_08")
    public void Teste_CA_08() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[99];

        q1.setUser_answer("no"); //resposta correta
        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
            arrayIQuestions[i] = q1;
        }

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta
        demoTest.addQuestion(q1);

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().correctAnswers());
    }

    @Test
    @DisplayName("CA_09")
    public void Teste_CA_09() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[99];

        q1.setUser_answer("yes");  //resposta correta
        demoTest.addQuestion(q1);

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no"); //resposta correta
        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
            arrayIQuestions[i] = q1;
        }

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().correctAnswers());
    }

    @Test
    @DisplayName("CA_10")
    public void Teste_CA_10() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[100];

        q1.setUser_answer("no"); //resposta correta
        for (int i = 0; i < 100; i++) {
            demoTest.addQuestion(q1);
            arrayIQuestions[i] = q1;
        }

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().correctAnswers());
    }


    //MÉTODO INCORRECTANSWERS()

    @Test
    @DisplayName("IA_01")
    public void Teste_IA_01() throws TestException {

        demoTest = new implementation.controller.Test();
        IQuestion[] arrayQuestoesIncorretas = new IQuestion[50];

        q1.setUser_answer("yes"); //resposta incorreta
        for (int i = 0; i < 50; i++) {
            arrayIQuestions[i] = q1;
        }
        demoTestStatistics = new implementation.controller.TestStatistics(arrayIQuestions);

        for (int i = 0; i < 100; i++) {
            if (arrayIQuestions[i] != null  && ((IQuestionYesNo) (arrayIQuestions[i])).getCorrect_answer() != ((IQuestionYesNo) (arrayIQuestions[i])).getUser_answer()) {
                arrayQuestoesIncorretas[i] = ((IQuestionYesNo) (arrayIQuestions[i]));
            }
        }

        assertArrayEquals(arrayQuestoesIncorretas, demoTestStatistics.incorrectAnswers());
    }

    @Test
    @DisplayName("IA_02")
    public void Teste_IA_02() throws TestException {

        demoTest = new implementation.controller.Test();
        q1.setUser_answer("no"); //resposta correta

        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> {
            for (int i = 0; i < 102; i++) {
                demoTest.addQuestion(q1);
            }
            demoTest.getTestStatistics().incorrectAnswers();
        });
    }

    @Test
    @DisplayName("IA_03")
    public void Teste_IA_03() throws TestException {

        demoTest = new implementation.controller.Test();
        q1.setUser_answer("no"); //resposta correta
        for (int i = 0; i < 100; i++) {
            demoTest.addQuestion(q1);
        }

        arrayIQuestions = new IQuestion[0];
        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().incorrectAnswers());
    }

    @Test
    @DisplayName("IA_04")
    public void Teste_IA_04() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[1];

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta
        demoTest.addQuestion(q1);
        arrayIQuestions[0] = q1;

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta

        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
        }

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().incorrectAnswers());
    }

    @Test
    @DisplayName("IA_05")
    public void Teste_IA_05() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[1];

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta
        demoTest.addQuestion(q1);

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta
        demoTest.addQuestion(q1);
        arrayIQuestions[0] = q1;

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta

        for (int i = 0; i < 98; i++) {
            demoTest.addQuestion(q1);
        }

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().incorrectAnswers());
    }

    @Test
    @DisplayName("IA_06")
    public void Teste_IA_06() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[1];
        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta
        for (int i = 0; i < 98; i++) {
            demoTest.addQuestion(q1);
        }

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta
        demoTest.addQuestion(q1);
        arrayIQuestions[0] = q1;

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().incorrectAnswers());
    }

    @Test
    @DisplayName("IA_07")
    public void Teste_IA_07() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[1];

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta
        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
        }

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes");  //resposta incorreta
        demoTest.addQuestion(q1);
        arrayIQuestions[0] = q1;

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().incorrectAnswers());
    }

    @Test
    @DisplayName("IA_08")
    public void Teste_IA_08() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[99];

        q1.setUser_answer("yes"); //resposta incorreta
        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
            arrayIQuestions[i] = q1;
        }

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("no");  //resposta correta
        demoTest.addQuestion(q1);

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().incorrectAnswers());
    }

    @Test
    @DisplayName("IA_09")
    public void Teste_IA_09() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[99];

        q1.setUser_answer("no");  //resposta correta
        demoTest.addQuestion(q1);

        q1 = new QuestionYesNo("title", "testDescription");
        q1.setCorrect_answer("no");
        q1.setUser_answer("yes"); //resposta incorreta
        for (int i = 0; i < 99; i++) {
            demoTest.addQuestion(q1);
            arrayIQuestions[i] = q1;
        }

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().incorrectAnswers());
    }

    @Test
    @DisplayName("IA_10")
    public void Teste_IA_10() throws TestException {

        demoTest = new implementation.controller.Test();
        arrayIQuestions = new IQuestion[100];

        q1.setUser_answer("yes"); //resposta incorreta
        for (int i = 0; i < 100; i++) {
            demoTest.addQuestion(q1);
            arrayIQuestions[i] = q1;
        }

        assertArrayEquals(arrayIQuestions, demoTest.getTestStatistics().incorrectAnswers());
    }


    //MÉTODO CORRECTANSWERSPERCENTAGEM()

        /*
    @org.junit.jupiter.api.Test
    @DisplayName("CAP_01")
    public void cap01(){
        demoTest.getTestStatistics().correctAnswerPecentage(1,2);
    }
     */

    @org.junit.jupiter.api.Test
    @DisplayName("CAP_02")
    public void cap02() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }
        demoTest.getQuestion(0).setDone(true);
        assertThrows(TestException.class, ()-> demoTest.getTestStatistics().correctAnswerPecentage());
    }


    @org.junit.jupiter.api.Test
    @DisplayName("CAP_03")
    public void cap03() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i< demoTest.numberQuestions(); i++) {
            demoTest.getQuestion(i).answer("5");
        }
        assertEquals(0.0, demoTest.getTestStatistics().correctAnswerPecentage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("CAP_04")
    public void cap04() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }
        demoTest.getQuestion(0).answer("4");

        for (int i = 1; i< demoTest.numberQuestions(); i++) {
            demoTest.getQuestion(i).answer("5");
        }
        assertEquals(0.01, demoTest.getTestStatistics().correctAnswerPecentage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("CAP_05")
    public void cap05() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i< 51; i++) {
            demoTest.getQuestion(i).answer("4");
        }
        for (int i = 51; i< demoTest.numberQuestions(); i++) {
            demoTest.getQuestion(i).answer("5");
        }
        assertEquals(0.5, demoTest.getTestStatistics().correctAnswerPecentage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("CAP_06")
    public void cap06() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i< 98; i++) {

            demoTest.getQuestion(i).answer("4");
        }

        demoTest.getQuestion(99).answer("5");

        assertEquals(0.99, demoTest.getTestStatistics().correctAnswerPecentage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("CAP_07")
    public void cap07() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i< 99; i++) {

            demoTest.getQuestion(i).answer("4");
        }


        assertEquals(1, demoTest.getTestStatistics().correctAnswerPecentage());
    }


    //MÉTODO INCORRECTANSWERSPERCENTAGEM()

        /*
    @org.junit.jupiter.api.Test
    @DisplayName("IAP_01")
    public void iap01(){
        demoTest.getTestStatistics().incorrectAnswerPecentage(1,2);
    }
     */

    @org.junit.jupiter.api.Test
    @DisplayName("IAP_02")
    public void iap02() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }
        demoTest.getQuestion(0).setDone(true);
        assertThrows(TestException.class, ()-> demoTest.getTestStatistics().incorrectAnswerPecentage());
    }


    @org.junit.jupiter.api.Test
    @DisplayName("IAP_03")
    public void iap03() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }

        for (int i = 0; i< demoTest.numberQuestions(); i++) {
            demoTest.getQuestion(i).answer("4");
        }
        assertEquals(0.0, demoTest.getTestStatistics().incorrectAnswerPecentage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("IAP_04")
    public void iap04() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }

        demoTest.getQuestion(0).answer("5");

        for (int i = 1; i< demoTest.numberQuestions(); i++) {
            demoTest.getQuestion(i).answer("4");
        }
        assertEquals(0.01, demoTest.getTestStatistics().incorrectAnswerPecentage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("IAP_05")
    public void iap05() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i< 51; i++) {
            demoTest.getQuestion(i).answer("5");
        }
        for (int i = 51; i< demoTest.numberQuestions(); i++) {
            demoTest.getQuestion(i).answer("4");
        }
        assertEquals(0.5, demoTest.getTestStatistics().incorrectAnswerPecentage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("IAP_06")
    public void iap06() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }
        for (int i = 0; i< 98; i++) {

            demoTest.getQuestion(i).answer("5");
        }

        demoTest.getQuestion(99).answer("4");

        assertEquals(0.99, demoTest.getTestStatistics().incorrectAnswerPecentage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("IAP_07")
    public void iap07() throws TestException {
        for (int i = 0; i < 99; i++) {
            IQuestionNumeric questionNumeric = new QuestionNumeric(4, "Calculo", "2*2");
            demoTest.addQuestion(questionNumeric);
        }

        for (int i = 0; i< 99; i++) {

            demoTest.getQuestion(i).answer("5");
        }


        assertEquals(1, demoTest.getTestStatistics().incorrectAnswerPecentage());
    }


}