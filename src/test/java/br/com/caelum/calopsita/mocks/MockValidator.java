package br.com.caelum.calopsita.mocks;

import org.jmock.Expectations;
import org.jmock.Mockery;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Validations;

public class MockValidator implements Validator {

	private final Mockery mockery;
	private boolean hasError;

	public MockValidator() {
		mockery =  new Mockery();

		mockery.checking(new Expectations() {
			{
				ignoring(anything());
			}
		});
	}
	public void add(Message message) {
	}

	public void checking(Validations rules) {
		hasError = hasError || !rules.getErrors().isEmpty();
	}

	public <T> T goTo(Class<T> type) {
		return mockery.mock(type);
	}

	@Override
	public Validator onError() {
		return this;
	}

	public void validate() {
	}

	public boolean hasError() {
		return hasError;
	}


}