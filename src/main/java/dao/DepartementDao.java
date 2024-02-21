package dao;

import test.testjpa.domain.Departement;

public class DepartementDao extends AbstractJpaDao<Long, Departement>{

	public DepartementDao() {
		super(Departement.class);
	}
}
