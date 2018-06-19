-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Июн 09 2018 г., 10:05
-- Версия сервера: 10.1.30-MariaDB
-- Версия PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `university`
--

-- --------------------------------------------------------

--
-- Структура таблицы `lecture`
--

CREATE TABLE `lecture` (
  `professor` int(11) NOT NULL,
  `students_group` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lecture`
--

INSERT INTO `lecture` (`professor`, `students_group`) VALUES
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `professors`
--

CREATE TABLE `professors` (
  `professor_id` int(11) NOT NULL,
  `professor_name` varchar(30) NOT NULL,
  `professor_experience` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `professors`
--

INSERT INTO `professors` (`professor_id`, `professor_name`, `professor_experience`) VALUES
(1, 'Pavel Emelianovich', 16),
(2, 'Irina Sidenko', 19);

-- --------------------------------------------------------

--
-- Структура таблицы `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(30) NOT NULL,
  `student_dob` date NOT NULL,
  `student_group` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `students`
--

INSERT INTO `students` (`student_id`, `student_name`, `student_dob`, `student_group`) VALUES
(1, 'Valerii Aurelur', '1995-04-09', 1),
(2, 'Anatol Cuperman', '1998-03-26', 1),
(4, 'Avraham Licoln', '1999-01-15', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `students_group`
--

CREATE TABLE `students_group` (
  `group_id` int(11) NOT NULL,
  `group_name` varchar(10) NOT NULL,
  `faculty` enum('Law','Math','Informatics','Economy','Languages','Chemistry','Physics') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `students_group`
--

INSERT INTO `students_group` (`group_id`, `group_name`, `faculty`) VALUES
(1, 'IA1604', 'Informatics'),
(2, 'L1106', 'Law');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `lecture`
--
ALTER TABLE `lecture`
  ADD KEY `professor` (`professor`),
  ADD KEY `students_group` (`students_group`);

--
-- Индексы таблицы `professors`
--
ALTER TABLE `professors`
  ADD PRIMARY KEY (`professor_id`);

--
-- Индексы таблицы `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `student_group` (`student_group`);

--
-- Индексы таблицы `students_group`
--
ALTER TABLE `students_group`
  ADD PRIMARY KEY (`group_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `professors`
--
ALTER TABLE `professors`
  MODIFY `professor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `students`
--
ALTER TABLE `students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `students_group`
--
ALTER TABLE `students_group`
  MODIFY `group_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `lecture`
--
ALTER TABLE `lecture`
  ADD CONSTRAINT `lecture_ibfk_1` FOREIGN KEY (`professor`) REFERENCES `professors` (`professor_id`),
  ADD CONSTRAINT `lecture_ibfk_2` FOREIGN KEY (`students_group`) REFERENCES `students_group` (`group_id`);

--
-- Ограничения внешнего ключа таблицы `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`student_group`) REFERENCES `students_group` (`group_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
