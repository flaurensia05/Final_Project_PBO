### Nama Anggota Kelompok 
### 1. Diah Adi Sriatna (1917051009)
### 2. Viny Silvia (1917051010)
### 3. Flaurensia Riahta Tarigan (1917051011)

### Pembagian Tugas :
### 1. Membuat Design Database di php myadmin (Flaurensia)
### 2. Membuat Class Diagram di mermaid live editor (Viny)
### 3. Membuat ERD di mermaid live editor (Diah)
### 4. Menyusun file README.md (Diah, Viny, Flauren melalui gmeet)
### 5. Membuat kode program oop di netbeans (Diah, Viny, Flauren melalui gmeet)
### 6. Membuat kode program db helper di netbeans (Diah, Viny, Flauren melalui gmeet)
### 7. Membuat desain GUI di scene builer (Diah, Viny, Flauren melalui gmeet)

> Untuk melihat diagram, install plugin mermaid-diagram di https://github.com/Redisrupt/mermaid-diagrams

### Class Diagram

```mermaid
classDiagram
      Peminjam <|-- AkunMahasiswa
      Peminjam <|-- AkunPelajar
      Peminjam "1"--o"*" DataPinjam : mempunyai

      class Peminjam{
        <<abstract>>
        #int IDAkun
        #String email
        #String password
        +int nextID()
      }
      
      class AkunMahasiswa{
          -String universitas
      }
      class AkunPelajar{
          -String nama_sekolah
      }
      class DataPinjam{
          -int IDBuku
          -String NamaBuku
          -String TanggalPinjam
      }
```		
### ER Diagram

```mermaid
erDiagram
          PEMINJAM ||..|| AKUNMAHASISWA : is
          PEMINJAM ||--|| AKUNPELAJAR : is
          PEMINJAM ||--|{ DATAPINJAM : has
```
### Design Class Diagram for JavaFX and Database

```mermaid
classDiagram
      Peminjam <|-- AkunMahasiswa
      Peminjam <|-- AkunPelajar
      Peminjam "1"--o"*" DataPinjam : mempunyai
      Peminjam o-- PerpusDataModeller : Data Modeling
      PerpusDataModeller <-- FormController : Data Control
      PerpusDataModeller --> DBHelper : DB Connection
      FormController <.. Form : Form Control

      class Peminjam{
        <<abstract>>
        #IntegerProperty IDAkun
        #StringProperty email
        #StringProperty password
        +int nextID()
      }
      
      class AkunMahasiswa{
        -StringProperty universitas
      }
      class AkunPelajar{
        -StringProperty nama_sekolah
      }
      class DataPinjam{
        -IntegerProperty IDBuku
        -StringProperty NamaBuku
        -StringrProperty TanggalPinjam
      }
      class PerpusDataModeller{
        Connection conn
        Tambah_Peminjaman()
        getAkunMahasiswa()
        getAkunPelajar()
        getDataPinjam()
        nextIDPerlengkapan()
      }
      class FormController{
        inisialisasi()
        handleButtonTambahPeminjaman()
        handleButtonTambahBuku()
        handleButtonReload()
        handleButtonClear()
      }
      class DBHelper{
        getConnection()
        getConnection(String driver)
      }
      class Form{
      }
```
