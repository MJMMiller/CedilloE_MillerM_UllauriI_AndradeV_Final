# 🔐 SCAP — Sistema de Cerrajería Automático Personalizado

**Proyecto:** SCAP (Sistema de Cerrajería Automático Personalizado)  
**Integrantes:** Nicolás Cedillo, Victoria Andrade, Mateo Miller, Isabel Ullauri

---

## ✨ Resumen
SCAP es un sistema híbrido (hardware + software) para control de acceso.  
Incluye:
- Un firmware para Arduino (lectura de keypad, manejo de LCD I2C, LEDs, buzzer y servo).
- Una aplicación administrativa en Java (gestión de usuarios, tiempos, logs y comunicación serial con el Arduino).

Este repositorio contiene el sketch de Arduino, scripts SQL, el manual de usuario y la estructura del proyecto Java (Maven).

---

## 📦 Estado actual (resumen rápido)
- ✅ Firmware Arduino: presente — `CedilloE_MillerM_UllauriI_AndradeV_Final.ino`  
- ✅ SQL (esquema/consultas): presente — `CedilloE_MillerM_UllauriI_AndradeV_Final.sql`  
- 📄 Manual de usuario (Word): presente — `Manual de Usuario SCAP.docx`  
- ⚠️ Proyecto Java (Maven): `CedilloE_MillerM_UllauriI_AndradeV_Final/pom.xml` presente, pero **`src/main/java` no se encontró o está vacío** en la rama actual. (La app Java podría faltar en la rama principal.)

> 🔎 Nota: Si quieres ver los archivos en GitHub, visita el repositorio:
> https://github.com/MJMMiller/CedilloE_MillerM_UllauriI_AndradeV_Final

---

## 📁 Contenido principal del repositorio (archivos clave)
- [CedilloE_MillerM_UllauriI_AndradeV_Final.ino](https://github.com/MJMMiller/CedilloE_MillerM_UllauriI_AndradeV_Final/blob/main/CedilloE_MillerM_UllauriI_AndradeV_Final.ino)  
  Sketch de Arduino que controla LCD I2C, servo, keypad, LEDs y buzzer. Incluye manejo de comandos serial desde la aplicación Java (prefijos `OK:` y `ERR:`).

- [CedilloE_MillerM_UllauriI_AndradeV_Final.sql](https://github.com/MJMMiller/CedilloE_MillerM_UllauriI_AndradeV_Final/blob/main/CedilloE_MillerM_UllauriI_AndradeV_Final.sql)  
  Script SQL con creación de tablas (usuarios, logs, datos) y ejemplos de consultas.

- [Manual de Usuario SCAP.docx](https://github.com/MJMMiller/CedilloE_MillerM_UllauriI_AndradeV_Final/blob/main/Manual%20de%20Usuario%20SCAP.docx)  
  Manual completo en formato Word (hardware y software). Recomendable publicar también en PDF o Markdown para fácil lectura en GitHub.

- [CedilloE_MillerM_UllauriI_AndradeV_Final/pom.xml](https://github.com/MJMMiller/CedilloE_MillerM_UllauriI_AndradeV_Final/blob/main/CedilloE_MillerM_UllauriI_AndradeV_Final/pom.xml)  
  Archivo Maven con dependencias: `mysql-connector-j` (8.4.0), `jcalendar` (1.4) y `jSerialComm` (2.11.0). Observación: `maven.compiler.release` = 24 (requiere JDK 24).

---

## 🗄️ Base de datos Entidad - Relacion

![Foto del entidad-relacion](https://raw.githubusercontent.com/MJMMiller/CedilloE_MillerM_UllauriI_AndradeV_Final/refs/heads/main/CedilloE_MillerM_UllauriI_AndradeV_Final_Entidad-Relacion.png)

---

## 🧩 Conexiones del circuito

![Foto del circuito](https://raw.githubusercontent.com/MJMMiller/CedilloE_MillerM_UllauriI_AndradeV_Final/refs/heads/main/CedilloE_MillerM_UllauriI_AndradeV_Final.png)

---

## 🛠️ SCAP — Mapeo de pines y conexiones (Arduino)

### Pines digitales (en el sketch)
- 🟢 LED_VERDE — digital 2  
- 🔔 BUZZER — digital 3  
- 🔴 LED_ROJO — digital 4  
- 🌀 SERVO_PIN — digital 5 (PWM)

### Keypad 4x4 (matriz)
- Filas (ROW):
  - ROW 1 → digital 6
  - ROW 2 → digital 7
  - ROW 3 → digital 8
  - ROW 4 → digital 9
- Columnas (COL):
  - COL 1 → digital 10
  - COL 2 → digital 11
  - COL 3 → digital 12
  - COL 4 → digital 13

> ⚠️ Nota: El pin 13 tiene un LED integrado en la placa; al usarlo para el keypad es posible que ese LED parpadee durante el escaneo.

### LCD 16x2 (I2C)
- SDA → A4  
- SCL → A5  
- VCC → 5V  
- GND → GND  
- Dirección I2C (en el sketch): `0x27`

### Alimentación y GND
- 🔌 GND común: conectar GND de Arduino, servo (si usa fuente externa), buzzer, LCD y keypad.  
- 🔋 5V: VCC para LCD y keypad desde Arduino; para servos, se recomienda fuente externa estable si el consumo es alto (con GND común).
