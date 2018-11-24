package br.com.exemplo.codigo.organizado;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteCampoTreinamento.class
})
public class SuiteTeste {

}
