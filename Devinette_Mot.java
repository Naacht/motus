package MonPackage;
import java.util.*;

public class Devinette_Mot
{
	public static void main(String[] args)
	{
		//Saisie du mot � deviner
		String Mot = Saisie.lire_String("L'ordinateur saisit un mot de mininum 5 lettres :");
		while (Mot.length() < 5)
		{
			Mot = Saisie.lire_String("Erreur, l'ordinateur doit saisir un mot de minimum 5 lettres :");
		}
		char[] MotSaisi = Mot.toCharArray();
		
		//D�claration et instanciation des variables de la boucle
		int LongueurMot = MotSaisi.length, Essais = LongueurMot - 2, x = 0;
		boolean fin = false;
		char[] LettresCommunes = new char[LongueurMot];
		
		//Boucle qui s'ex�cute tant que le mot n'est pas trouv� ou qu'il reste des essais pour le trouver
		while(Essais != 0 && fin == false)
		{
			//Saisie d'un essai de mot � deviner
			String Essai = Saisie.lire_String("Vous avez " + Essais + " essais pour deviner le mot de " + LongueurMot + " lettres (tapez SOL pour arr�ter) :");
			
			//La solution s'affiche si l'utilisateur d�cide de taper SOL
			if (Essai.equals("SOL"))
			{
				Essais = 0;
				break;
			}
			while (Essai.length() != LongueurMot)
			{
				Essai = Saisie.lire_String("Erreur, le mot � deviner contient " + LongueurMot + " lettres :");
			}
			char[] EssaiSaisi = Essai.toCharArray();
			Essais--;
			int NbrLettresCommunes = 0;
			
			//Si le mot est trouv�, fin du jeu
			if(Arrays.equals(EssaiSaisi, MotSaisi))
			{
				fin = true;
			}
		
			//Sinon on cherche et affiche les lettres communes entre le mot � deviner et le mot de l'essai
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
				//Affichage et comptage des lettres communes et bien plac�es
				System.out.print("Vous avez trouv� " + NbrLettresCommunes + " lettres qui sont les suivantes : ");
				for (x=0; x < LongueurMot; x++)
				{
					System.out.print(LettresCommunes[x] + " ");
				}
				System.out.println("");
			}
		}
		//Messages qui s'affichent si le joueur perd ou gagne
		if (Essais == 0) System.out.println("Perdu ! Le mot �tait " + Mot);
		else System.out.println("F�licitations, vous avez devin� le mot en " + ((Mot.length() - 2) - Essais) + " essai(s) !");	
	}

}