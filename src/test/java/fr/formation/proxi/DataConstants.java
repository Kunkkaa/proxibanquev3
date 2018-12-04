package fr.formation.proxi;

import java.util.Arrays;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;

public class DataConstants {

	public static final Account ACCOUNT_1 = new Account(1, "0005", 500F);
	public static final Account ACCOUNT_2 = new Account(2, "0011", 99F);
	public static final Client CLIENT_1 = new Client(1, "jeremy", "Masson",
			"elvy@gmail.com", "5 rue des trucs",
			Arrays.asList(ACCOUNT_1, ACCOUNT_2));
}
