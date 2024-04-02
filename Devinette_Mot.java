package MonPackage;
import java.util.*;

public class Devinette_Mot
{
	public static void main(String[] args)
	{
		//Saisie du mot à deviner
		String Mot = Saisie.lire_String("L'ordinateur saisit un mot de mininum 5 lettres :");
		while (Mot.length() < 5)
		{
			Mot = Saisie.lire_String("Erreur, l'ordinateur doit saisir un mot de minimum 5 lettres :");
		}
		char[] MotSaisi = Mot.toCharArray();
		
		//Déclaration et instanciation des variables de la boucle
		int LongueurMot = MotSaisi.length, Essais = LongueurMot - 2, x = 0;
		boolean fin = false;
		char[] LettresCommunes = new char[LongueurMot];
		
		//Boucle qui s'exécute tant que le mot n'est pas trouvé ou qu'il reste des essais pour le trouver
		while(Essais != 0 && fin == false)
		{
			//Saisie d'un essai de mot à deviner
			String Essai = Saisie.lire_String("Vous avez " + Essais + " essais pour deviner le mot de " + LongueurMot + " lettres (tapez SOL pour arrêter) :");
			
			//La solution s'affiche si l'utilisateur décide de taper SOL
			if (Essai.equals("SOL"))
			{
				Essais = 0;
				break;
			}
			while (Essai.length() != LongueurMot)
			{
				Essai = Saisie.lire_String("Erreur, le mot à deviner contient " + LongueurMot + " lettres :");
			}
			char[] EssaiSaisi = Essai.toCharArray();
			Essais--;
			int NbrLettresCommunes = 0;
			
			//Si le mot est trouvé, fin du jeu
			if(Arrays.equals(EssaiSaisi, MotSaisi))
			{
				fin = true;
			}
		
			//Sinon on cherche et affiche les lettres communes entre le mot à deviner et le mot de l'essai
			else
			{
				for (x=0; x < LongueurMot; x++)
				{
					if (MotSaisi[x] == EssaiSaisi[x])
					{
						NbrLettresCommunes++;
						LettresCommunes[x] = EssaiSaisi[x];
					}
					else if (EssaiSaisi[x] != MotSaisi[x])
					{
						LettresCommunes[x] = '_';
					}
				}				
				//Affichage et comptage des lettres communes et bien placées
				System.out.print("Vous avez trouvé " + NbrLettresCommunes + " lettres qui sont les suivantes : ");
				for (x=0; x < LongueurMot; x++)
				{
					System.out.print(LettresCommunes[x] + " ");
				}
				System.out.println("");
			}
		}
		//Messages qui s'affichent si le joueur perd ou gagne
		if (Essais == 0) System.out.println("Perdu ! Le mot était " + Mot);
		else System.out.println("Félicitations, vous avez deviné le mot en " + ((Mot.length() - 2) - Essais) + " essai(s) !");	
	}

}