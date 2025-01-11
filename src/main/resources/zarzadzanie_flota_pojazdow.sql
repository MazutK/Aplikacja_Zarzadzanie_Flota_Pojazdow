-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sty 11, 2025 at 12:48 PM
-- Wersja serwera: 10.4.32-MariaDB
-- Wersja PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zarzadzanie_flota_pojazdow`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kierowcy`
--

CREATE TABLE `kierowcy` (
  `PESEL` bigint(20) NOT NULL,
  `Imię` varchar(50) DEFAULT NULL,
  `Nazwisko` varchar(50) DEFAULT NULL,
  `DataUrodzenia` date DEFAULT NULL,
  `NumerPrawoJazdy` varchar(20) DEFAULT NULL,
  `Uprawnienia` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kierowcy`
--

INSERT INTO `kierowcy` (`PESEL`, `Imię`, `Nazwisko`, `DataUrodzenia`, `NumerPrawoJazdy`, `Uprawnienia`) VALUES
(80030178901, 'Monika', 'Mazurek', '1982-10-30', 'D7890123', 'D'),
(80040556789, 'Tomasz', 'Lewandowski', '1980-04-05', 'B5678901', 'B'),
(80040756789, 'Grzegorz', 'Pawłowski', '1980-04-07', 'C5678901', 'C'),
(81091378901, 'Adam', 'Czajka', '1981-12-14', 'C7890123', 'C'),
(82011234567, 'Piotr', 'Wójcik', '1982-12-01', 'B3456789', 'B'),
(82051089012, 'Renata', 'Olszewska', '1990-03-13', 'F8901234', 'F'),
(82051423456, 'Izabela', 'Baran', '1993-03-06', 'E2345678', 'E'),
(83012578901, 'Krzysztof', 'Szymański', '1988-01-25', 'B7890123', 'B'),
(83040978901, 'Ryszard', 'Brzozowski', '1984-09-14', 'E7890123', 'E'),
(83071334567, 'Łukasz', 'Wróblewski', '1984-12-12', 'D3456789', 'D'),
(83072212345, 'Piotr', 'Wojciechowski', '1983-10-22', 'C1234567', 'C'),
(84021901234, 'Rafał', 'Mazur', '1981-08-14', 'E0123456', 'E'),
(84061290123, 'Jadwiga', 'Dąbrowska', '1984-06-12', 'B9012345', 'B'),
(85020156789, 'Mariusz', 'Nowakowski', '1980-05-20', 'E5678901', 'E'),
(85021512345, 'Jan', 'Kowalski', '1985-02-15', 'B1234567', 'B, C'),
(85060356789, 'Dariusz', 'Chmiel', '1993-04-04', 'D5678901', 'D'),
(85092067890, 'Beata', 'Zielonka', '1988-04-22', 'F6789012', 'F'),
(86020289012, 'Magdalena', 'Sienkiewicz', '1989-02-01', 'C8901234', 'C'),
(86022834567, 'Maciej', 'Jankowski', '1986-02-28', 'C3456789', 'C'),
(86050189012, 'Halina', 'Zawisza', '1985-01-07', 'E8901234', 'E'),
(86051023456, 'Jolanta', 'Michałowska', '1992-08-10', 'F2345678', 'F'),
(86081889012, 'Sebastian', 'Wójcik', '1986-11-25', 'D8901234', 'D'),
(86090990123, 'Jacek', 'Wiśniewski', '1992-06-01', 'G9012345', 'G'),
(86091812345, 'Wojciech', 'Duda', '1985-09-18', 'D1234567', 'D'),
(87061745678, 'Maria', 'Kamińska', '1987-09-17', 'B4567890', 'B, C'),
(87072534567, 'Tadeusz', 'Król', '1988-06-14', 'E3456789', 'E'),
(88033012345, 'Marcin', 'Kaczmarek', '1990-12-09', 'E1234567', 'E'),
(88041390123, 'Zbigniew', 'Jasinski', '1987-04-13', 'C9012345', 'C'),
(88071834567, 'Zofia', 'Sikorska', '1986-11-02', 'F3456789', 'F'),
(88080890123, 'Roman', 'Majewski', '1989-03-11', 'F9012345', 'F'),
(89010245678, 'Joanna', 'Kaczmarek', '1990-11-21', 'D4567890', 'D'),
(89081901234, 'Andrzej', 'Kozłowski', '1989-08-19', 'C0123456', 'C'),
(90052645678, 'Stanislaw', 'Wilk', '1983-09-05', 'F4567890', 'F'),
(90061278901, 'Sławomir', 'Bielecki', '1985-12-18', 'F7890123', 'F'),
(90072323456, 'Anna', 'Nowak', '1990-07-23', 'B2345678', 'B'),
(90091867890, 'Agnieszka', 'Bąk', '1987-07-28', 'E6789012', 'E'),
(91012101234, 'Jerzy', 'Skrzypek', '1990-02-20', 'F0123456', 'F'),
(91040101234, 'Marek', 'Piotrowski', '1992-01-30', 'D0123456', 'D'),
(91051223456, 'Barbara', 'Pawlak', '1991-05-11', 'C2345678', 'C'),
(92030967890, 'Ewa', 'Zielinska', '1992-03-09', 'B6789012', 'B'),
(92051490123, 'Elżbieta', 'Kowal', '1994-05-17', 'E9012345', 'E'),
(92080101234, 'Anna', 'Ślusarczyk', '1984-10-25', 'G0123456', 'G'),
(93070345678, 'Olga', 'Nowicka', '1993-07-03', 'C4567890', 'C'),
(93070867890, 'Jakub', 'Zawisza', '1991-07-13', 'D6789012', 'D'),
(93080156789, 'Tomasz', 'Borkowski', '1987-07-15', 'F5678901', 'F'),
(94021545678, 'Kamil', 'Michalski', '1992-04-02', 'E4567890', 'E'),
(94031512345, 'Tadeusz', 'Górski', '1981-06-30', 'F1234567', 'F'),
(94062167890, 'Katarzyna', 'Sikora', '1994-06-20', 'C6789012', 'C'),
(94082423456, 'Natalia', 'Kwiatkowska', '1988-08-24', 'D2345678', 'D');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `login`
--

CREATE TABLE `login` (
  `ID` int(11) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `Username`, `Password`) VALUES
(1, 'Admin', 'Admin');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pojazdy`
--

CREATE TABLE `pojazdy` (
  `PojazdID` int(11) NOT NULL,
  `NumerVIN` varchar(17) DEFAULT NULL,
  `Marka` varchar(50) DEFAULT NULL,
  `Model` varchar(50) DEFAULT NULL,
  `RokProdukcji` int(11) DEFAULT NULL,
  `NumerRejestracyjny` varchar(20) DEFAULT NULL,
  `StanTechniczny` varchar(50) DEFAULT NULL,
  `WymaganeUprawnienia` varchar(100) DEFAULT NULL,
  `UbezpieczenieID` int(11) DEFAULT NULL,
  `PrzeglądID` int(11) DEFAULT NULL,
  `TypPojazdu` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pojazdy`
--

INSERT INTO `pojazdy` (`PojazdID`, `NumerVIN`, `Marka`, `Model`, `RokProdukcji`, `NumerRejestracyjny`, `StanTechniczny`, `WymaganeUprawnienia`, `UbezpieczenieID`, `PrzeglądID`, `TypPojazdu`) VALUES
(1, '1A4B4D4C2GA123456', 'Scania', 'R450', 2020, 'ABC1234', 'Bardzo dobry', 'C+E', 1, 1, 'Ciągnik siodłowy'),
(2, '2A4B4D4C2HA654321', 'Volvo', 'FH16', 2019, 'XYZ5678', 'Dobry', 'C+E', 2, 2, 'Ciągnik siodłowy'),
(3, '3A4B4D4C2IA789012', 'Mercedes', 'Actros', 2021, 'QWE3456', 'Dobry', 'C+E', 3, 3, 'Ciągnik siodłowy'),
(4, '4A4B4D4C2JA123987', 'MAN', 'TGX', 2018, 'RTY5679', 'Średni', 'C+E', 4, 4, 'Ciągnik siodłowy'),
(5, '5A4B4D4C2KA234567', 'Iveco', 'Stralis', 2017, 'HJK8901', 'Dobry', 'C+E', 5, 5, 'Ciągnik siodłowy'),
(6, '6A4B4D4C2LA987654', 'Scania', 'P280', 2020, 'LMN2345', 'Bardzo dobry', 'C+E', 6, 6, 'Ciągnik siodłowy'),
(7, '7A4B4D4C2MA654321', 'MAN', 'TGS', 2021, 'VBN5678', 'Dobry', 'C+E', 7, 7, 'Ciągnik siodłowy'),
(8, '8A4B4D4C2NA123456', 'Volvo', 'FMX', 2020, 'OPQ9012', 'Średni', 'C+E', 8, 8, 'Ciągnik siodłowy'),
(9, '9A4B4D4C2PA654321', 'Mercedes', 'Atego', 2019, 'FGH2345', 'Dobry', 'C+E', 9, 9, 'Ciągnik siodłowy'),
(10, '0A4B4D4C2QA987654', 'Renault', 'T', 2018, 'ABC6789', 'Bardzo dobry', 'C+E', 10, 10, 'Ciągnik siodłowy'),
(11, '1A4B4D4C2RA123456', 'Scania', 'R500', 2021, 'LMN6789', 'Dobry', 'C+E', 11, 11, 'Ciągnik siodłowy'),
(12, '2A4B4D4C2SA654321', 'Volvo', 'FH12', 2020, 'QWE9876', 'Bardzo dobry', 'C+E', 12, 12, 'Ciągnik siodłowy'),
(13, '3A4B4D4C2TA789012', 'MAN', 'TGX', 2021, 'JKL2345', 'Dobry', 'C+E', 13, 13, 'Ciągnik siodłowy'),
(14, '4A4B4D4C2UA123987', 'Mercedes', 'Actros', 2019, 'RTY3456', 'Bardzo dobry', 'C+E', 14, 14, 'Ciągnik siodłowy'),
(15, '5A4B4D4C2VA234567', 'Renault', 'Premium', 2018, 'FGH5678', 'Średni', 'C+E', 15, 15, 'Ciągnik siodłowy'),
(16, '6A4B4D4C2WA987654', 'Iveco', 'Stralis', 2020, 'VBN8901', 'Bardzo dobry', 'C+E', 16, 16, 'Ciągnik siodłowy'),
(17, '7A4B4D4C2XA654321', 'Scania', 'R420', 2019, 'LMN1234', 'Dobry', 'C+E', 17, 17, 'Ciągnik siodłowy'),
(18, '8A4B4D4C2YA123456', 'MAN', 'TGS', 2021, 'OPQ2345', 'Bardzo dobry', 'C+E', 18, 18, 'Ciągnik siodłowy'),
(19, '9A4B4D4C2ZA654321', 'Volvo', 'FM12', 2020, 'RTY6789', 'Dobry', 'C+E', 19, 19, 'Ciągnik siodłowy'),
(20, '0A4B4D4C2AB987654', 'Mercedes', 'Atego', 2018, 'FGH6789', 'Średni', 'C+E', 20, 20, 'Ciągnik siodłowy'),
(21, '1A4B4D4C2BB123456', 'Scania', 'R500', 2021, 'LMN2345', 'Bardzo dobry', 'C+E', 21, 21, 'Ciągnik siodłowy'),
(22, '2A4B4D4C2CC654321', 'Volvo', 'FH16', 2021, 'XYZ8901', 'Bardzo dobry', 'C+E', 22, 22, 'Ciągnik siodłowy'),
(23, '3A4B4D4C2DD789012', 'Mercedes', 'Actros', 2019, 'JKL3456', 'Dobry', 'C+E', 23, 23, 'Ciągnik siodłowy'),
(24, '4A4B4D4C2EE123987', 'MAN', 'TGX', 2020, 'VBN4567', 'Średni', 'C+E', 24, 24, 'Ciągnik siodłowy'),
(25, '5A4B4D4C2FF234567', 'Renault', 'Premium', 2019, 'FGH6789', 'Bardzo dobry', 'C+E', 25, 25, 'Ciągnik siodłowy'),
(26, '6A4B4D4C2GG987654', 'Mercedes', 'Vito', 2021, 'JKL2345', 'Dobry', 'B', 26, 26, 'Bus'),
(27, '7A4B4D4C2HH654321', 'Volkswagen', 'Transporter', 2020, 'LMN2345', 'Średni', 'B', 27, 27, 'Bus'),
(28, '8A4B4D4C2II123456', 'Ford', 'Transit', 2019, 'XYZ1234', 'Bardzo dobry', 'B', 28, 28, 'Bus'),
(29, '9A4B4D4C2JJ654321', 'Mercedes', 'Sprinter', 2020, 'QWE3456', 'Średni', 'B', 29, 29, 'Bus'),
(30, '0A4B4D4C2KK987654', 'Renault', 'Master', 2021, 'JKL5678', 'Dobry', 'B', 30, 30, 'Bus'),
(31, '1A4B4D4C2LL123456', 'Audi', 'A4', 2020, 'LMN1234', 'Bardzo dobry', 'B', 31, 31, 'Osobowy'),
(32, '2A4B4D4C2MM654321', 'BMW', 'X5', 2019, 'QWE2345', 'Dobry', 'B', 32, 32, 'Osobowy'),
(33, '3A4B4D4C2NN789012', 'Mercedes', 'C-Class', 2020, 'XYZ3456', 'Średni', 'B', 33, 33, 'Osobowy'),
(34, '4A4B4D4C2OO123987', 'Volkswagen', 'Golf', 2021, 'RTY4567', 'Bardzo dobry', 'B', 34, 34, 'Osobowy'),
(35, '5A4B4D4C2PP234567', 'Ford', 'Focus', 2019, 'JKL5678', 'Dobry', 'B', 35, 35, 'Osobowy'),
(36, '6A4B4D4C2QQ987654', 'Mercedes', 'V-Class', 2021, 'VBN1234', 'Średni', 'B', 36, 36, 'Bus'),
(37, '7A4B4D4C2RR654321', 'Volkswagen', 'Sharan', 2020, 'OPQ2345', 'Bardzo dobry', 'B', 37, 37, 'Bus'),
(38, '8A4B4D4C2SS123456', 'Mercedes', 'Vito', 2021, 'JKL3456', 'Dobry', 'B', 38, 38, 'Bus'),
(39, '9A4B4D4C2TT654321', 'Ford', 'Transit', 2020, 'RTY5678', 'Bardzo dobry', 'B', 39, 39, 'Bus'),
(40, '0A4B4D4C2UU987654', 'Renault', 'Master', 2021, 'FGH2345', 'Dobry', 'B', 40, 40, 'Bus'),
(41, '1A4B4D4C2VV123456', 'Volkswagen', 'Transporter', 2019, 'JKL8901', 'Dobry', 'B', 41, 41, 'Bus'),
(42, '2A4B4D4C2WW654321', 'Peugeot', 'Expert', 2020, 'LMN6789', 'Średni', 'B', 42, 42, 'Bus'),
(43, '3A4B4D4C2XX789012', 'Opel', 'Vivaro', 2019, 'QWE9876', 'Bardzo dobry', 'B', 43, 43, 'Bus'),
(44, '4A4B4D4C2YY123987', 'Mercedes', 'Sprinter', 2021, 'VBN1234', 'Dobry', 'B', 44, 44, 'Bus'),
(45, '5A4B4D4C2ZZ234567', 'Ford', 'Transit', 2020, 'RTY2345', 'Bardzo dobry', 'B', 45, 45, 'Bus'),
(46, '6A4B4D4C2AA987654', 'Fiat', 'Ducato', 2021, 'LMN3456', 'Dobry', 'B', 46, 46, 'Bus'),
(47, '7A4B4D4C2BB654321', 'Renault', 'Master', 2020, 'OPQ5678', 'Średni', 'B', 47, 47, 'Bus'),
(48, '8A4B4D4C2CC123456', 'Peugeot', 'Boxer', 2019, 'JKL2345', 'Dobry', 'B', 48, 48, 'Bus'),
(49, '9A4B4D4C2DD654321', 'Volkswagen', 'Transporter', 2020, 'VBN6789', 'Bardzo dobry', 'B', 49, 49, 'Bus');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przegladtechniczny`
--

CREATE TABLE `przegladtechniczny` (
  `PrzegladID` int(11) NOT NULL,
  `PojazdID` int(11) DEFAULT NULL,
  `DataPrzegladu` date DEFAULT NULL,
  `WynikPrzegladu` varchar(100) DEFAULT NULL,
  `Uwagi` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `przegladtechniczny`
--

INSERT INTO `przegladtechniczny` (`PrzegladID`, `PojazdID`, `DataPrzegladu`, `WynikPrzegladu`, `Uwagi`) VALUES
(1, 1, '2024-01-15', 'Pozytywny', 'Wymiana oleju silnikowego, układ w dobrym stanie'),
(2, 2, '2024-02-10', 'Pozytywny', 'Sprawdzenie układu hamulcowego, wymiana klocków'),
(3, 3, '2024-03-05', 'Pozytywny', 'Wymiana filtrów powietrza, układ elektryczny sprawny'),
(4, 4, '2024-04-01', 'Pozytywny', 'Kontrola klimatyzacji, wymiana filtra kabinowego'),
(5, 5, '2024-05-10', 'Pozytywny', 'Wymiana opon, stan zawieszenia dobry'),
(6, 6, '2024-06-02', 'Pozytywny', 'Kontrola układu elektrycznego, wymiana akumulatora'),
(7, 7, '2024-07-18', 'Pozytywny', 'Wymiana płynów eksploatacyjnych, układ w dobrym stanie'),
(8, 8, '2024-08-03', 'Pozytywny', 'Sprawdzenie układu chłodzenia, brak wycieków'),
(9, 9, '2024-09-10', 'Pozytywny', 'Wymiana klocków hamulcowych, układ hamulcowy sprawny'),
(10, 10, '2024-10-20', 'Pozytywny', 'Kontrola układu zasilania, wymiana filtrów paliwa'),
(11, 11, '2024-11-01', 'Pozytywny', 'Sprawdzenie opon, wymiana opon letnich na zimowe'),
(12, 12, '2024-12-03', 'Pozytywny', 'Wymiana tarcz hamulcowych, stan zawieszenia dobry'),
(13, 13, '2024-01-25', 'Pozytywny', 'Kontrola silnika, wymiana filtrów powietrza'),
(14, 14, '2024-02-14', 'Pozytywny', 'Kontrola układu wydechowego, brak usterek'),
(15, 15, '2024-03-08', 'Pozytywny', 'Wymiana filtrów oleju, układ silnikowy w dobrym stanie'),
(16, 16, '2024-04-15', 'Pozytywny', 'Sprawdzenie zawieszenia, stan pojazdu dobry'),
(17, 17, '2024-05-05', 'Pozytywny', 'Wymiana oleju, wymiana akumulatora'),
(18, 18, '2024-06-21', 'Pozytywny', 'Kontrola klimatyzacji, wymiana filtra kabinowego'),
(19, 19, '2024-07-12', 'Pozytywny', 'Wymiana filtrów paliwa, układ paliwowy sprawny'),
(20, 20, '2024-08-18', 'Pozytywny', 'Kontrola układu elektrycznego, wymiana żarówek'),
(21, 21, '2024-09-05', 'Pozytywny', 'Wymiana klocków hamulcowych, układ hamulcowy sprawny'),
(22, 22, '2024-10-08', 'Pozytywny', 'Kontrola opon, wymiana filtrów powietrza'),
(23, 23, '2024-11-15', 'Pozytywny', 'Sprawdzenie układu wydechowego, brak usterek'),
(24, 25, '2024-04-01', 'Pozytywny', 'Kontrola układu wydechowego, wymiana tłumika'),
(25, 26, '2024-07-11', 'Pozytywny', 'Wymiana filtrów paliwa, system paliwowy w dobrym stanie'),
(26, 27, '2024-02-25', 'Pozytywny', 'Układ elektryczny sprawny, brak usterek'),
(27, 28, '2024-03-17', 'Pozytywny', 'Wymiana klocków hamulcowych, stan zawieszenia dobry'),
(28, 29, '2024-06-13', 'Pozytywny', 'Klimatyzacja działa prawidłowo, wymiana filtra kabinowego'),
(29, 30, '2024-04-25', 'Pozytywny', 'Wymiana oleju silnikowego, stan techniczny dobry'),
(30, 31, '2024-05-19', 'Pozytywny', 'Układ hamulcowy w dobrym stanie, wymiana tarcz'),
(31, 32, '2024-08-22', 'Pozytywny', 'Sprawdzenie silnika, brak usterek'),
(32, 33, '2024-10-10', 'Pozytywny', 'Wymiana tarcz hamulcowych, układ hamulcowy działa poprawnie'),
(33, 34, '2024-01-29', 'Pozytywny', 'Wymiana filtrów powietrza, stan techniczny pojazdu dobry'),
(34, 35, '2024-07-02', 'Pozytywny', 'Sprawdzono układ chłodzenia, brak przecieków'),
(35, 36, '2024-03-28', 'Pozytywny', 'Wymiana opon, stan techniczny dobry'),
(36, 37, '2024-09-15', 'Pozytywny', 'Kontrola układu wydechowego, układ w dobrym stanie'),
(37, 38, '2024-04-17', 'Pozytywny', 'Kontrola układu wydechowego, wymiana tłumika'),
(38, 39, '2024-10-11', 'Pozytywny', 'Sprawdzenie opon, wymiana filtrów powietrza'),
(39, 40, '2024-06-28', 'Pozytywny', 'Sprawdzono zawieszenie, brak usterek'),
(40, 1, '2024-12-05', 'Pozytywny', 'Kontrola układu elektrycznego, wymiana akumulatora'),
(41, 2, '2024-12-03', 'Pozytywny', 'Wymiana płynów eksploatacyjnych, układ w dobrym stanie'),
(42, 3, '2024-12-02', 'Pozytywny', 'Kontrola układu paliwowego, wymiana filtrów'),
(43, 4, '2024-12-04', 'Pozytywny', 'Kontrola poziomu oleju, wymiana filtra oleju'),
(44, 5, '2024-12-01', 'Pozytywny', 'Sprawdzenie oświetlenia, wymiana żarówek'),
(45, 6, '2024-11-29', 'Pozytywny', 'Wymiana filtrów oleju, układ olejowy w dobrym stanie'),
(46, 7, '2024-11-27', 'Pozytywny', 'Kontrola układu hamulcowego, wymiana klocków'),
(47, 8, '2024-11-25', 'Pozytywny', 'Wymiana oleju i filtrów, układ w dobrym stanie'),
(48, 9, '2024-11-23', 'Pozytywny', 'Kontrola zawieszenia, stan pojazdu bardzo dobry'),
(49, 10, '2024-11-20', 'Pozytywny', 'Kontrola klimatyzacji, wymiana filtra kabinowego'),
(51, 12, '2024-11-16', 'Pozytywny', 'Wymiana płynów eksploatacyjnych, układ chłodzenia sprawny'),
(52, 13, '2024-11-14', 'Pozytywny', 'Kontrola układu chłodzenia, brak wycieków'),
(53, 14, '2024-11-12', 'Pozytywny', 'Wymiana akumulatora, układ elektryczny sprawny'),
(54, 15, '2024-11-10', 'Pozytywny', 'Kontrola silnika, wymiana filtrów powietrza'),
(55, 16, '2024-11-08', 'Pozytywny', 'Sprawdzenie opon, stan techniczny dobry'),
(56, 17, '2024-11-06', 'Pozytywny', 'Wymiana oleju i filtrów, układ silnikowy w dobrym stanie'),
(57, 18, '2024-11-04', 'Pozytywny', 'Kontrola układu zasilania, wymiana wtryskiwaczy'),
(58, 19, '2024-11-02', 'Pozytywny', 'Kontrola układu wydechowego, wymiana tłumika'),
(59, 20, '2024-10-31', 'Pozytywny', 'Sprawdzenie hamulców, wymiana tarcz hamulcowych'),
(60, 21, '2024-10-29', 'Pozytywny', 'Wymiana tarcz hamulcowych, układ w dobrym stanie'),
(61, 22, '2024-10-27', 'Pozytywny', 'Kontrola systemu oświetlenia, wymiana żarówek'),
(62, 23, '2024-10-25', 'Pozytywny', 'Kontrola klimatyzacji, wymiana filtra kabinowego'),
(63, 24, '2024-10-23', 'Pozytywny', 'Wymiana płynów eksploatacyjnych, układ w dobrym stanie'),
(64, 25, '2024-10-21', 'Pozytywny', 'Kontrola układu elektrycznego, wymiana akumulatora'),
(65, 26, '2024-10-19', 'Pozytywny', 'Wymiana filtra powietrza, układ w dobrym stanie'),
(66, 27, '2024-10-17', 'Pozytywny', 'Kontrola układu kierowniczego, brak usterek'),
(67, 28, '2024-10-15', 'Pozytywny', 'Sprawdzenie systemu paliwowego, wymiana filtrów'),
(68, 29, '2024-10-13', 'Pozytywny', 'Wymiana akumulatora, układ elektryczny sprawny'),
(69, 30, '2024-10-11', 'Pozytywny', 'Kontrola układu wydechowego, brak usterek'),
(70, 31, '2024-10-09', 'Pozytywny', 'Wymiana oleju silnikowego, stan techniczny dobry'),
(71, 32, '2024-10-07', 'Pozytywny', 'Kontrola opon, wymiana opon letnich na zimowe'),
(72, 33, '2024-10-05', 'Pozytywny', 'Wymiana klocków hamulcowych, układ w dobrym stanie'),
(73, 34, '2024-10-03', 'Pozytywny', 'Kontrola zawieszenia, stan pojazdu bardzo dobry'),
(74, 35, '2024-10-01', 'Pozytywny', 'Kontrola układu zasilania, wymiana filtra paliwa'),
(75, 36, '2024-09-29', 'Pozytywny', 'Wymiana filtrów paliwa, układ w dobrym stanie'),
(76, 37, '2024-09-27', 'Pozytywny', 'Kontrola systemu chłodzenia, brak wycieków'),
(77, 38, '2024-09-25', 'Pozytywny', 'Wymiana opon, stan techniczny dobry'),
(78, 39, '2024-09-23', 'Pozytywny', 'Kontrola układu hamulcowego, wymiana klocków'),
(79, 40, '2024-09-21', 'Pozytywny', 'Sprawdzenie układu wydechowego, wymiana tłumika'),
(80, 1, '2024-09-19', 'Pozytywny', 'Kontrola układu elektrycznego, wymiana akumulatora'),
(81, 2, '2024-09-17', 'Pozytywny', 'Kontrola klimatyzacji, wymiana filtra kabinowego'),
(82, 3, '2024-09-15', 'Pozytywny', 'Wymiana filtrów oleju, stan techniczny pojazdu dobry'),
(83, 4, '2024-09-13', 'Pozytywny', 'Kontrola opon, wymiana opon zimowych'),
(84, 5, '2024-09-11', 'Pozytywny', 'Kontrola układu chłodzenia, brak przecieków'),
(85, 6, '2024-09-09', 'Pozytywny', 'Sprawdzenie silnika, wymiana filtrów powietrza'),
(86, 7, '2024-09-07', 'Pozytywny', 'Kontrola układu wydechowego, brak usterek'),
(87, 8, '2024-09-05', 'Pozytywny', 'Kontrola układu zasilania, wymiana wtryskiwaczy'),
(88, 9, '2024-09-03', 'Pozytywny', 'Wymiana akumulatora, układ elektryczny sprawny'),
(89, 10, '2024-09-01', 'Pozytywny', 'Kontrola zawieszenia, stan techniczny dobry'),
(90, 11, '2024-08-30', 'Pozytywny', 'Wymiana filtrów powietrza, układ w dobrym stanie'),
(91, 12, '2024-08-28', 'Pozytywny', 'Kontrola układu kierowniczego, brak usterek'),
(92, 13, '2024-08-26', 'Pozytywny', 'Kontrola układu elektrycznego, wymiana akumulatora'),
(93, 14, '2024-08-24', 'Pozytywny', 'Wymiana oleju silnikowego, stan techniczny dobry'),
(94, 15, '2024-08-22', 'Pozytywny', 'Kontrola klimatyzacji, wymiana filtra kabinowego'),
(95, 16, '2024-08-20', 'Pozytywny', 'Wymiana filtrów paliwa, układ w dobrym stanie'),
(96, 17, '2024-08-18', 'Pozytywny', 'Kontrola zawieszenia, stan pojazdu bardzo dobry'),
(97, 18, '2024-08-16', 'Pozytywny', 'Kontrola opon, wymiana klocków hamulcowych'),
(98, 19, '2024-08-14', 'Pozytywny', 'Kontrola układu wydechowego, wymiana tłumika'),
(99, 20, '2024-08-12', 'Pozytywny', 'Kontrola układu elektrycznego, wymiana żarówek'),
(100, 21, '2024-08-10', 'Pozytywny', 'Kontrola układu hamulcowego, wymiana tarcz'),
(101, 5, '2023-01-02', 'pozytywny', 'brak');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przypisania`
--

CREATE TABLE `przypisania` (
  `PrzypisanieID` int(11) NOT NULL,
  `PojazdID` int(11) DEFAULT NULL,
  `PESEL` bigint(20) DEFAULT NULL,
  `DataPrzypisania` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `przypisania`
--

INSERT INTO `przypisania` (`PrzypisanieID`, `PojazdID`, `PESEL`, `DataPrzypisania`) VALUES
(1, 1, 85021512345, '2024-12-07'),
(2, 1, 90072323456, '2024-12-07'),
(3, 2, 82011234567, '2024-12-07'),
(4, 2, 87061745678, '2024-12-07'),
(5, 3, 80040556789, '2024-12-07'),
(6, 3, 92030967890, '2024-12-07'),
(7, 4, 83012578901, '2024-12-07'),
(9, 5, 84061290123, '2024-12-07'),
(10, 5, 89081901234, '2024-12-07'),
(11, 6, 83072212345, '2024-12-07'),
(12, 6, 91051223456, '2024-12-07'),
(13, 7, 86022834567, '2024-12-07'),
(14, 7, 93070345678, '2024-12-07'),
(15, 8, 80040756789, '2024-12-07'),
(16, 8, 94062167890, '2024-12-07'),
(17, 9, 81091378901, '2024-12-07'),
(18, 9, 86020289012, '2024-12-07'),
(19, 10, 88041390123, '2024-12-07'),
(20, 10, 91040101234, '2024-12-07'),
(21, 11, 86091812345, '2024-12-07'),
(22, 11, 94082423456, '2024-12-07'),
(23, 12, 83071334567, '2024-12-07'),
(24, 12, 89010245678, '2024-12-07'),
(25, 13, 85060356789, '2024-12-07'),
(26, 13, 93070867890, '2024-12-07'),
(27, 14, 80030178901, '2024-12-07'),
(28, 14, 86081889012, '2024-12-07'),
(29, 15, 92051490123, '2024-12-07'),
(30, 15, 84021901234, '2024-12-07'),
(31, 16, 88033012345, '2024-12-07'),
(32, 16, 82051423456, '2024-12-07'),
(33, 17, 87072534567, '2024-12-07'),
(34, 17, 94021545678, '2024-12-07'),
(35, 18, 85020156789, '2024-12-07'),
(36, 18, 90091867890, '2024-12-07'),
(37, 19, 83040978901, '2024-12-07'),
(38, 19, 86050189012, '2024-12-07'),
(39, 20, 88080890123, '2024-12-07'),
(40, 20, 91012101234, '2024-12-07'),
(41, 21, 94031512345, '2024-12-07'),
(42, 21, 86051023456, '2024-12-07'),
(43, 22, 88071834567, '2024-12-07'),
(44, 22, 90052645678, '2024-12-07'),
(45, 23, 93080156789, '2024-12-07'),
(46, 23, 85092067890, '2024-12-07'),
(47, 24, 90061278901, '2024-12-07'),
(48, 24, 82051089012, '2024-12-07'),
(49, 25, 86090990123, '2024-12-07'),
(50, 25, 92080101234, '2024-12-07'),
(51, 26, 85021512345, '2024-12-07'),
(52, 27, 90072323456, '2024-12-07'),
(53, 28, 82011234567, '2024-12-07'),
(54, 29, 87061745678, '2024-12-07'),
(55, 30, 80040556789, '2024-12-07'),
(56, 31, 92030967890, '2024-12-07'),
(57, 32, 83012578901, '2024-12-07'),
(59, 34, 84061290123, '2024-12-07'),
(60, 35, 89081901234, '2024-12-07'),
(61, 36, 83072212345, '2024-12-07'),
(62, 37, 91051223456, '2024-12-07'),
(63, 38, 86022834567, '2024-12-07'),
(64, 39, 93070345678, '2024-12-07'),
(65, 40, 80040756789, '2024-12-07'),
(66, 41, 94062167890, '2024-12-07'),
(67, 42, 81091378901, '2024-12-07'),
(68, 43, 86020289012, '2024-12-07'),
(69, 44, 88041390123, '2024-12-07'),
(70, 45, 91040101234, '2024-12-07');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ubezpieczenia`
--

CREATE TABLE `ubezpieczenia` (
  `UbezpieczenieID` int(11) NOT NULL,
  `PojazdID` int(11) DEFAULT NULL,
  `RodzajUbezpieczenia` varchar(50) DEFAULT NULL,
  `DataRozpoczęcia` date DEFAULT NULL,
  `DataZakończenia` date DEFAULT NULL,
  `Koszt` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ubezpieczenia`
--

INSERT INTO `ubezpieczenia` (`UbezpieczenieID`, `PojazdID`, `RodzajUbezpieczenia`, `DataRozpoczęcia`, `DataZakończenia`, `Koszt`) VALUES
(1, 1, 'OC', '2023-01-01', '2025-06-30', 1200.00),
(2, 13, 'OC', '2023-01-01', '2025-06-30', 1100.00),
(3, 3, 'OC', '2023-03-01', '2025-06-30', 1300.00),
(4, 20, 'AC', '2023-07-01', '2025-06-30', 2700.00),
(5, 18, 'AC', '2023-05-01', '2025-06-30', 2500.00),
(6, 6, 'OC', '2023-07-01', '2025-06-30', 1300.00),
(7, 5, 'OC', '2023-05-01', '2025-06-30', 1100.00),
(8, 17, 'OC', '2023-04-01', '2025-06-30', 1350.00),
(9, 16, 'AC', '2023-03-01', '2025-06-30', 2450.00),
(10, 4, 'AC', '2023-04-01', '2025-06-30', 2400.00),
(11, 7, 'AC', '2023-08-01', '2025-06-30', 2600.00),
(12, 10, 'AC', '2023-10-01', '2025-06-30', 2550.00),
(13, 14, 'AC', '2023-01-01', '2025-06-30', 2350.00),
(14, 12, 'OC', '2023-11-01', '2025-06-30', 1400.00),
(15, 8, 'AC', '2023-06-01', '2025-06-30', 2300.00),
(16, 19, 'OC', '2023-06-01', '2025-06-30', 1200.00),
(17, 11, 'AC', '2023-12-01', '2025-06-30', 2800.00),
(18, 9, 'OC', '2023-09-01', '2025-06-30', 1250.00),
(19, 15, 'OC', '2023-02-01', '2025-06-30', 1500.00),
(20, 2, 'AC', '2023-02-01', '2025-06-30', 2500.00),
(21, 23, 'OC', '2023-10-01', '2025-06-30', 1550.00),
(22, 21, 'OC', '2023-08-01', '2025-06-30', 1450.00),
(23, 22, 'AC', '2023-09-01', '2025-06-30', 2200.00),
(24, 24, 'AC', '2023-11-01', '2025-06-30', 2300.00),
(25, 25, 'OC', '2023-12-01', '2025-06-30', 1400.00),
(27, 26, 'AC', '2023-01-01', '2025-06-30', 2600.00),
(28, 28, 'AC', '2023-03-01', '2025-06-30', 2400.00),
(30, 27, 'OC', '2023-02-01', '2025-06-30', 1500.00),
(31, 29, 'OC', '2023-04-01', '2025-06-30', 1350.00),
(32, 30, 'AC', '2023-05-01', '2025-06-30', 2550.00),
(33, 31, 'OC', '2023-06-01', '2025-06-30', 1300.00),
(34, 32, 'AC', '2023-07-01', '2025-06-30', 2500.00),
(35, 33, 'OC', '2023-08-01', '2025-06-30', 1200.00),
(36, 34, 'AC', '2023-09-01', '2025-06-30', 2400.00),
(37, 35, 'OC', '2023-10-01', '2025-06-30', 1250.00),
(38, 36, 'AC', '2023-11-01', '2025-06-30', 2450.00),
(39, 37, 'OC', '2023-12-01', '2025-06-30', 1150.00),
(40, 38, 'AC', '2023-01-01', '2025-06-30', 2300.00),
(41, 39, 'OC', '2023-02-01', '2025-06-30', 1200.00),
(42, 40, 'AC', '2023-03-01', '2025-06-30', 2350.00),
(43, 41, 'OC', '2023-04-01', '2025-06-30', 1250.00),
(44, 42, 'AC', '2023-05-01', '2025-06-30', 2200.00),
(45, 43, 'OC', '2023-06-01', '2025-06-30', 1150.00),
(46, 44, 'AC', '2023-07-01', '2025-06-30', 2250.00),
(47, 45, 'OC', '2023-08-01', '2025-06-30', 1100.00),
(48, 46, 'AC', '2023-09-01', '2025-06-30', 2500.00),
(49, 47, 'OC', '2023-10-01', '2025-06-30', 1300.00);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `kierowcy`
--
ALTER TABLE `kierowcy`
  ADD PRIMARY KEY (`PESEL`),
  ADD UNIQUE KEY `unique_numer_prawo_jazdy` (`NumerPrawoJazdy`);

--
-- Indeksy dla tabeli `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID`);

--
-- Indeksy dla tabeli `pojazdy`
--
ALTER TABLE `pojazdy`
  ADD PRIMARY KEY (`PojazdID`),
  ADD UNIQUE KEY `NumerVIN` (`NumerVIN`),
  ADD UNIQUE KEY `unique_combination` (`NumerVIN`,`UbezpieczenieID`,`PrzeglądID`),
  ADD UNIQUE KEY `unique_combinatio` (`NumerVIN`,`UbezpieczenieID`,`PrzeglądID`),
  ADD UNIQUE KEY `unique_numer_vin` (`NumerVIN`),
  ADD UNIQUE KEY `unique_ubezpieczenie_id` (`UbezpieczenieID`),
  ADD UNIQUE KEY `unique_przeglad_id` (`PrzeglądID`);

--
-- Indeksy dla tabeli `przegladtechniczny`
--
ALTER TABLE `przegladtechniczny`
  ADD PRIMARY KEY (`PrzegladID`),
  ADD KEY `PojazdID` (`PojazdID`);

--
-- Indeksy dla tabeli `przypisania`
--
ALTER TABLE `przypisania`
  ADD PRIMARY KEY (`PrzypisanieID`),
  ADD KEY `PojazdID` (`PojazdID`),
  ADD KEY `PESEL` (`PESEL`);

--
-- Indeksy dla tabeli `ubezpieczenia`
--
ALTER TABLE `ubezpieczenia`
  ADD PRIMARY KEY (`UbezpieczenieID`),
  ADD UNIQUE KEY `unique_pojazd_id` (`PojazdID`),
  ADD KEY `PojazdID` (`PojazdID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pojazdy`
--
ALTER TABLE `pojazdy`
  MODIFY `PojazdID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `przegladtechniczny`
--
ALTER TABLE `przegladtechniczny`
  ADD CONSTRAINT `przegladtechniczny_ibfk_1` FOREIGN KEY (`PojazdID`) REFERENCES `pojazdy` (`PojazdID`);

--
-- Constraints for table `przypisania`
--
ALTER TABLE `przypisania`
  ADD CONSTRAINT `przypisania_ibfk_1` FOREIGN KEY (`PojazdID`) REFERENCES `pojazdy` (`PojazdID`),
  ADD CONSTRAINT `przypisania_ibfk_2` FOREIGN KEY (`PESEL`) REFERENCES `kierowcy` (`PESEL`);

--
-- Constraints for table `ubezpieczenia`
--
ALTER TABLE `ubezpieczenia`
  ADD CONSTRAINT `ubezpieczenia_ibfk_1` FOREIGN KEY (`PojazdID`) REFERENCES `pojazdy` (`PojazdID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
