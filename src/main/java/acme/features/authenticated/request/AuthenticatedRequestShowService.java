
package acme.features.authenticated.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request;
import acme.framework.components.Model;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedRequestShowService implements AbstractShowService<Authenticated, Request> {

	@Autowired
	AuthenticatedRequestRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "ticker", "title", "creationMoment", "deadline", "text", "reward");
	}

	@Override
	public Request findOne(final acme.framework.components.Request<Request> request) {
		assert request != null;
		int id = request.getModel().getInteger("id");
		Request res = this.repository.findOneById(id);
		return res;
	}

}
