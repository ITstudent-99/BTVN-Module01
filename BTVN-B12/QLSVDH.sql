CREATE DATABASE IF NOT EXISTS QL_SINHVIEN;
USE QL_SINHVIEN;

-- Tạo bảng SinhVien
CREATE TABLE SinhVien (
	id INT AUTO_INCREMENT,
    ho_ten VARCHAR(50) NOT NULL,
    ngay_sinh DATE,
    gioi_tinh VARCHAR(10),
	dia_chi VARCHAR(255),
    email VARCHAR(100) UNIQUE,
    diem_trung_binh DECIMAL(4,2),
    PRIMARY KEY (id)
);

-- Tạo bảng MonHoc (bổ sung PRIMARY KEY)
CREATE TABLE MonHoc (
	id_mon INT AUTO_INCREMENT,
    ten_mon VARCHAR(100),
    so_tin_chi INT,
    PRIMARY KEY (id_mon)
);

-- Tạo bảng DiemThi
CREATE TABLE DiemThi (
	id_diem INT AUTO_INCREMENT,
    id_sinhvien INT,
    id_mon INT,
    diem DECIMAL(4,2),
    PRIMARY KEY (id_diem),
    FOREIGN KEY (id_sinhvien) REFERENCES SinhVien(id),
    FOREIGN KEY (id_mon) REFERENCES MonHoc(id_mon)
);


-- 3.	Thêm dữ liệu vào các bảng:
-- o	Thêm ít nhất 5 sinh viên vào bảng SinhVien.
-- o	Thêm ít nhất 3 môn học vào bảng MonHoc.
-- o	Thêm kết quả thi của các sinh viên vào bảng DiemThi.

INSERT INTO SinhVien (ho_ten, ngay_sinh, gioi_tinh, dia_chi, email) VALUES
('Nguyen Van A', '2002-05-14', 'Nam', 'Hà Nội', 'a.nguyen@example.com'),
('Tran Thi B', '2003-07-22', 'Nữ', 'Hồ Chí Minh', 'b.tran@example.com'),
('Le Van C', '2001-12-01', 'Nam', 'Đà Nẵng', 'c.le@example.com'),
('Pham Thi D', '2002-09-09', 'Nữ', 'Cần Thơ', 'd.pham@example.com'),
('Hoang Van E', '2003-01-20', 'Nam', 'Hải Phòng', 'e.hoang@example.com');

SELECT * FROM SinhVien;

INSERT INTO MonHoc (ten_mon, so_tin_chi) VALUES
('Toán Cao Cấp', 3),
('Cơ Sở Dữ Liệu', 4),
('Lập Trình C++', 3);

SELECT * FROM MonHoc;

INSERT INTO DiemThi (id_sinhvien, id_mon, diem) VALUES
(1, 1, 7.5),
(1, 2, 8.0),
(2, 2, 9.2),
(2, 3, 8.4),
(3, 1, 6.8),
(3, 3, 7.0),
(4, 1, 9.5),
(4, 2, 8.7),
(5, 2, 7.3),
(5, 3, 7.8);

SELECT * FROM DiemThi;

-- Mac dinh diem TB la 0.00
ALTER TABLE SinhVien 
MODIFY diem_trung_binh DECIMAL(4,2) DEFAULT 0.00;

-- Them 1 Sinhvien
INSERT INTO SinhVien (ho_ten, ngay_sinh, gioi_tinh, dia_chi, email)
VALUES ('Vo Thi G', '2004-04-12', 'Nữ', 'Bình Định', 'g.vo@example.com');

-- 4.	Cập nhật dữ liệu:
-- o	Cập nhật điểm trung bình của một sinh viên trong bảng SinhVien.
-- o	Cập nhật điểm thi của một sinh viên trong bảng DiemThi.

-- Cap nhat diem thi cua mot sinh vien ngau nhien
UPDATE DiemThi
SET diem = 9.00
WHERE id_diem = 5;

-- Tinh diem TB cua tat ca sinh vien
-- B1 Xem điểm trung bình của từng sinh viên (không cập nhật)
SELECT 
    SV.id,
    SV.ho_ten,
    ROUND(AVG(DT.diem), 2) AS diem_trung_binh
FROM 
    SinhVien SV
JOIN 
    DiemThi DT ON SV.id = DT.id_sinhvien
GROUP BY 
    SV.id, SV.ho_ten;
-- B2 Cap nhat diem

-- Tat safemode de update toan bo du lieu 
SET SQL_SAFE_UPDATES = 0;

UPDATE SinhVien SV
JOIN (
    SELECT 
        id_sinhvien, 
        ROUND(AVG(diem), 2) AS diem_tb
    FROM DiemThi
    GROUP BY id_sinhvien
) AS DT ON SV.id = DT.id_sinhvien
SET SV.diem_trung_binh = DT.diem_tb;

-- Mo lai Safemode, khi update du lieu can WHERE
SET SQL_SAFE_UPDATES = 1;



-- 5.	Truy vấn dữ liệu:
-- o	Liệt kê tất cả sinh viên và thông tin của họ từ bảng SinhVien.
SELECT * FROM SinhVien;

-- o	Liệt kê tất cả môn học với số tín chỉ từ bảng MonHoc.
SELECT * FROM MonHoc;

-- o	Hiển thị tên sinh viên, môn học và điểm thi của sinh viên đó từ bảng 
-- SinhVien, MonHoc, DiemThi bằng cách sử dụng câu lệnh JOIN.
SELECT SV.id, SV.ho_ten, mh.ten_mon, dt.diem FROM SinhVien as SV
JOIN DiemThi as dt ON SV.id = dt.id_sinhvien
JOIN MonHoc as mh ON dt.id_mon = mh.id_mon;

SELECT 
    SV.id, 
    SV.ho_ten, 
    mh.ten_mon, 
    dt.diem 
FROM 
    SinhVien AS SV
LEFT JOIN DiemThi AS dt ON SV.id = dt.id_sinhvien
LEFT JOIN MonHoc AS mh ON dt.id_mon = mh.id_mon;

-- o	Tìm tất cả các sinh viên có điểm trung bình lớn hơn 8.0.
SELECT * FROM SinhVien
WHERE SinhVien.diem_trung_binh > 8;

-- o	Liệt kê các môn học mà sinh viên có điểm thi dưới 5.0.
SELECT * FROM DiemThi;
-- Them 1 sv thi duoi 5
INSERT INTO DiemThi (id_sinhvien, id_mon, diem) VALUES
(6, 1, 3.5);

SELECT DISTINCT MH.ten_mon
FROM DiemThi DT
JOIN MonHoc MH ON DT.id_mon = MH.id_mon
WHERE DT.diem < 5.0;

-- o	Đếm số lượng sinh viên có điểm thi môn học trên 6.0.
-- C1
SELECT COUNT(*) AS SL_SinhVien
FROM (
    SELECT id_sinhvien
    FROM DiemThi
    WHERE diem > 6
    GROUP BY id_sinhvien
) AS temp;

-- C2
SELECT COUNT(DISTINCT id_sinhvien) AS so_sinh_vien
FROM DiemThi
WHERE diem > 6.0;

-- Hien thi cac sinh vien do
SELECT DISTINCT SV.id, SV.ho_ten
FROM SinhVien SV
JOIN DiemThi DT ON SV.id = DT.id_sinhvien
WHERE DT.diem > 6.0;


-- 6.	Sử dụng các toán tử và biểu thức so sánh:
-- o	Tìm tất cả sinh viên có điểm trung bình từ 7.0 đến 8.5 và giới tính là "Nam".
SELECT * FROM SinhVien
WHERE diem_trung_binh BETWEEN 7.00 AND 8.50 AND gioi_tinh = "Nam";  -- BETWEEN tuong duong >= va <=

-- o	Liệt kê tất cả sinh viên có email chứa "gmail.com" hoặc "yahoo.com".
SELECT * 
FROM SinhVien
WHERE email LIKE '%gmail.com%' 
   OR email LIKE '%yahoo.com%';


-- o	Sử dụng toán tử AND/OR để tìm sinh viên có điểm trung bình lớn hơn 6.5 và có ít nhất một môn thi điểm dưới 5.0.
SELECT DISTINCT SV.*
FROM SinhVien SV
JOIN DiemThi DT ON SV.id = DT.id_sinhvien
WHERE SV.diem_trung_binh > 6.5
  AND DT.diem < 5.0;

-- 7.	Sử dụng GROUP BY và COUNT:
-- o	Đếm số lượng sinh viên có điểm thi môn học lớn hơn 6.0, nhóm theo môn học.
SELECT 
    MH.ten_mon,
    COUNT(DISTINCT DT.id_sinhvien) AS so_luong_sinh_vien
FROM 
    DiemThi DT
JOIN 
    MonHoc MH ON DT.id_mon = MH.id_mon
WHERE 
    DT.diem > 6.0
GROUP BY 
    MH.ten_mon;

-- o	Tính số sinh viên thi lại (điểm dưới 5.0) cho từng môn học.
SELECT 
    MH.ten_mon,
    COUNT(DISTINCT DT.id_sinhvien) AS so_sinh_vien_thi_lai
FROM 
    DiemThi DT
JOIN 
    MonHoc MH ON DT.id_mon = MH.id_mon
WHERE 
    DT.diem < 5.0
GROUP BY 
    MH.ten_mon;
