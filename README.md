# Testez-une-application-full-stack

Réaliser le test de l'application de réservation yoga-app, depuis l’écriture des tests jusqu’à leur exécution. Le test front-end, back-end et end-to-end.

. Télécharger et installer MySQLServer and MySQLWorkbench et note bien le login et le mot de passe.

. Télécharger Maven et configuré les variables d'environnement dans le but d'utiliser la commande 'mvn'.

# Configuration de la Base de données

    Avec MySQLWorkbench, créer a un nouveau schema nommé "yoga". Définissez-le comme schéma par défaut.
    Excuter cette script:

    https://github.com/OpenClassrooms-Student-Center/Testez-une-application-full-stack/blob/master/ressources/sql/script.sql

# Obtenez le code source

    git clone https://github.com/fatmadev123/Testez-une-application-full-stack.git

# Configuration et exécution du Back-end

    Ouvrez ce fichier :  https://github.com/fatmadev123/Testez-une-application-full-stack/blob/main/back/src/main/resources/application.properties

Insérez votre login et votre mot de passe de SQLServer pour ces lignes :

    spring.datasource.username=
    spring.datasource.password=

Allez dans le dossier nommé back

    cd back

Exécuter le projet

    mvn spring-boot:run

# Configuration et exécution du Front-end

Allez dans le dossier nommé front

    cd front

Installer les dependences

    npm install

Exécuter le projet

    npm start

    L'application s'ouvre ici :  http://localhost:4200
    Essayez de vous connecter avec ce compte : email: yoga@studio.com password: test!1234

# Test Front-end

    Exécuter des tests front-end

    npx jest --coverage

    Coverage report:

    /Testez-une-application-full-stack/front/coverage/jest/lcov-report/index.html

# Test End-to-end

    Exécuter des tests end-to-end

    npm run e2e

    Generer le fichier de coverage (seulement si le test e2e est realisé avant)

    npm run e2e:coverage

    Avec le moteur de recherche Cypress, Executer le fichier nomméé 'all-tests.cy.ts' pour obtenir le coverage pour tous les tests end-to-end de projet.
    Coverage report:

    /Testez-une-application-full-stack/front/coverage/lcov-report/index.html

# Test Back-end

    Accéder au dossier back de projet:
    Executer back-end tests :

    mvn clean test

    Coverage report:

    /Testez-une-application-full-stack/back/target/site/jacoco/index.html

Author
Fatma Zammel
