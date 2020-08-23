package modelo.teste;

import com.modelo.projeto.entity.Pessoa;
import com.modelo.projeto.transaction.PessoaTransaction;
import java.math.BigInteger;
import static java.time.OffsetTime.now;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Rule;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author vcoelho
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PessoaTransaction.class, System.class})
public class PessoaTest {

	@Mock
	private PessoaTransaction dao;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void test_modelo() throws Exception {
		Pessoa input = mock(Pessoa.class);
		input = this.dao.insert(input);
		System.out.println("Pessoa:"+ input);
		Pessoa p = mockPessoa(1l);
		when(this.dao.buscar(1l)).thenReturn(p);
		
		List<Pessoa> list = dao.todos();
		
		error.checkThat(list.size(), is(equalTo(BigInteger.ZERO)));
	}

	private Pessoa mockPessoa(Long codigo) {
		Pessoa c = mock(Pessoa.class);
		when(c.getId()).thenReturn(codigo);
		return c;
	}
}
