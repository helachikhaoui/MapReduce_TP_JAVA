# MapReduce en JAVA

Le fichier en entrée est un fichier log dont les champs sont de la forme suivante:

date temps magasin produit coût paiement


Les codes du mapper et du reducer sont écrits en JAVA. 


## A propos 
Ce code a été testé sur la machine virtuelle de Cloudera qui est une machine Linux, distribution CentOS, sur laquelle est installé Hadoop ainsi
qu'un IDE Eclipse. 

Dans un premier lieu, nous allons tester le mapper et le reducer en local, ensuite nous allons exécuter le code directement sur HDFS.


# Tester le code en local

## Prérequis 
Il faut s'assurer que les jars __Hadoop Common__ et __MapReduce Client Core__ sont dans le Build Path.
D'autres dépendances également s'avèrent être nécessaires :
    
    
* slf4j-nop
* jackson-core-asl
* httpclient
* jackson-mapper-asl
    
## Instructions
1. Spécifier les chemins des arguments utilisés par l'entrée main (Le fichier des données et le répertoire du résultat) du programme dans l'onglet "Arguments" de "Run Configurations" du projet sous Eclipse.

2. Exécuter le programme.

3. Visualiser le résultat dans le fichier __part-r-00000__ sous le répertoire précisé dans l'étape 1.

# Tester le code sur HDFS 
Une fois le code fonctionne convenablement en local , on peut le déployer sur le cluster de Hadoop. Pour ce faire, il suffit de suivre les étapes ci-dessous.
## Instructions
1. Sous Eclipse, exporter le jar du projet JAVA.

2. Mettre le fichier des données sur HDFS : hadoop fs –put [fichier des données] [répertoire destination]

3. Ouvrir un terminal et lancer la commande suivante: __hadoop jar [jar du projet] [Nom du point d'entrée main dans le jar] [fichier des données] [répertoire du résultat]__

4. Visualiser le résulat dans le ficher __part-r-00000__ sous le répertoire précisé dans l'étape 2 en lançant la commande suivante: __hadoop fs –cat [répertoire destination]/part-r-00000__









