package com.microsoft.azure.services.serviceBus;


import java.util.ArrayList;

import javax.inject.Inject;

import com.microsoft.azure.configuration.Configuration;
import com.microsoft.azure.services.serviceBus.contract.EntryModel;
import com.microsoft.azure.services.serviceBus.contract.QueueDescription;
import com.microsoft.azure.services.serviceBus.contract.ServiceBusContract;

public class ServiceBusClient  {

	ServiceBusContract contract;

	public ServiceBusClient() throws Exception {
		this(Configuration.getInstance());
	}
	
	public ServiceBusClient(Configuration config) throws Exception {
		this(config.create(ServiceBusContract.class));
	}
	
	@Inject
	public ServiceBusClient(ServiceBusContract contract) {
		this.contract = contract;
	}

	public ServiceBusContract getContract() {
		return contract;
	}

	public void setContract(ServiceBusContract contract) {
		this.contract = contract;
	}

	public Iterable<Queue> listQueues() {
		EntryModel<QueueDescription>[] descriptions = contract.getQueues();
		ArrayList<Queue> queues = new ArrayList<Queue>();
		for (int i = 0; i != descriptions.length; ++i) {
			queues.set(i, new Queue(this, null));
			queues.get(i).setEntryModel(descriptions[i]);
		}
		return queues;
	}

	public Queue getQueue(String path) {
		return new Queue(this, path);
	}

	public Iterable<Topic> listTopics() {
		return null;
	}
}
