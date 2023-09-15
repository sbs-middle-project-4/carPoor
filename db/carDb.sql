CREATE TABLE car (
id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` CHAR(20) NOT NULL,
size CHAR(20) NOT NULL,
`engine` CHAR(20) NOT NULL,
displacement INT UNSIGNED,
distanceDriven INT UNSIGNED,
minPrice INT UNSIGNED NOT NULL,
maxPrice INT UNSIGNED NOT NULL,
imgUrl TEXT NOT NULL
);



CREATE TABLE carDetail (
id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` CHAR(20) NOT NULL,
`color` CHAR(20) NOT NULL,
imgUrl TEXT NOT NULL
);

INSERT INTO carDetail
SET `name` = '흰색',
`color` = 'white',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/exterior/WW2/001.png'
;

INSERT INTO carDetail
SET `name` = '갈색',
`color` = 'brown',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/exterior/YBM/001.png'
;


CREATE TABLE carDetail2 (
id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` CHAR(50) NOT NULL,
`btnUrl` TEXT NOT NULL,
`imgUrl` TEXT NOT NULL
);

INSERT INTO carDetail2
SET `name` = '블랙 / 나파 가죽 시트',
btnUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/3NB/colorchip-interior.png',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/3NB/img-interior.png';

INSERT INTO carDetail2
SET `name` = '블랙 / 천연 가죽 시트',
btnUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/9NB/colorchip-interior.png',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/9NB/img-interior.png';

INSERT INTO carDetail2
SET `name` = '블랙 / 인조 가죽 시트',
btnUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/NNB/colorchip-interior.png',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/NNB/img-interior.png';


INSERT INTO carDetail2
SET `name` = '피칸 브라운 / 나파 가죽 시트',
btnUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/3PR/colorchip-interior.png',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/3PR/img-interior.png';

INSERT INTO carDetail2
SET `name` = '피칸 브라운 / 천연 가죽 시트',
btnUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/PCR/colorchip-interior.png',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/PCR/img-interior.png';

INSERT INTO carDetail2
SET `name` = '그레이 / 나파 가죽 시트',
btnUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/9YY/colorchip-interior.png',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/9YY/img-interior.png';

INSERT INTO carDetail2
SET `name` = '라이트 베이지 / 나파 가죽 시트',
btnUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/RXG/colorchip-interior.png',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/RXG/img-interior.png';

INSERT INTO carDetail2
SET `name` = '블랙잉크 / 나파 가죽 시트',
btnUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/4NB/colorchip-interior.png',
imgUrl = 'https://www.hyundai.com/contents/vr360/MX03/interior/4NB/img-interior.png';