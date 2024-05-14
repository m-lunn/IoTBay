-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: iotbay
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Products`
--

DROP TABLE IF EXISTS `Products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `product_description` varchar(1020) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL,
  `product_image_path` text,
  `product_active` bit(1) DEFAULT NULL,
  `product_category` text,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Products`
--

LOCK TABLES `Products` WRITE;
/*!40000 ALTER TABLE `Products` DISABLE KEYS */;
INSERT INTO `Products` VALUES (1,'TP-LINK TL-MR3420 3G/4G Wireless N300 Router','TP-LINK TL-MR3420 3G/4G N300 Wireless Router Connect a 3/4G USB dongle to TL-MR3420 and instantly create your own Wi-Fi hotspot. Share a stable internet connection with your friends and family. TL-MR3420 is compatible with the majority of brands, Struggling to get a fast connection with more devices? TL-MR3420 delivers up to 300Mbps speeds for up to 32 online devices at the same time. Stay connected with your smartphone, laptop, games console and more, TL-MR3420 also supports a WAN internet connection via an Ethernet cable. Switch between wired WAN and wireless 3/4G connections as required with this cost-effective all-in-one router.',399.00,'./product-images/routers/router1.webp',_binary '','router'),(2,'TP-Link TL-WR802N 300Mbps Wireless N Nano Router','TP-Link TL-WR802N 300Mbps Wireless N Nano WiFi Router To meet the wireless needs of almost any situation you might encounter, the TL-WR802N supports Router, Hotspot, Range Extender, Client and Access Point Modes Router mode; Instantly create a private wireless network and share Internet access with multiple Wi-Fi devices. Ideal for setup in most hotels.Hotspot Mode; Enjoy wireless Internet access by connecting to an outdoor WISP Access Point.',249.00,'./product-images/routers/router2.webp',_binary '','router'),(3,'NetComm NF18 CloudMesh Mesh Networking Gateway','The NF18MESH is a CloudMesh Gateway that will work wirelessly with the NS-01 CloudMesh Satellite, forming a single powerful Whole Home WiFi Mesh network with all the control and settings centralized on the Gateway. The Gateway becomes the WiFi Mesh master node with the WiFi client device roaming seamlessly between satellites and the gateway.',115.00,'./product-images/routers/router3.webp',_binary '','router'),(4,'Netcomm NS-01 CloudMesh Satellite Access Point','The NS-01 CloudMesh Satellite works wirelessly with a CloudMesh Gateway, forming a single powerful Whole Home WiFi Mesh network coverage.',100.00,'./product-images/routers/router4.webp',_binary '','router'),(5,'ASUS DSL-AX82U AX5400 Dual Band MU-MIMO WiFi 6 Modem Router','Enjoy the fast, flexible internet connections ever with the ASUS DSL-AX82U dual-band WiFi 6 modem router. It delivers ultrafast WiFi speeds up to 5400 Mbps, and is packed with multiple connectivity, including DSL port for an ADSL/VDSL connection, and Ethernet port for any ?ber or cable-based modems, or even an USB port for 3G/4G/5G mobile broadband connection, which makes it ideal for a ISP upgrade.',350.00,'./product-images/routers/router5.webp',_binary '','router'),(6,'Ubiquiti Networks NBE-5AC-GEN2 NanoBeam High-Performance airMAX AC Bridge','Ubiquiti Networks UBNT NBE-5AC-GEN2 NanoBeam High-Performance airMAX AC Bridge - 5GHz airMAX AC NanoBeam Gen2 CPE Radio with speeds up to 450+Mbps - 19dBi antenna - v8 airOS with airMAX processor & airMagic - RF shielding with improved RF isolation & noise immunity - Dedicated WiFi radio for management and quick setup via UMobile App - 24V 0.5A PoE adapter included - NBE-5AC-GEN2 - 12 Months Limited Warranty',80.00,'./product-images/routers/router6.webp',_binary '','router'),(7,'Ubiquiti Networks UP-Sense-3 Battery Powered Security Protect Sensor - 3 Pack','Ubiquiti Networks UP-Sense-3 Battery Powered Security Protect Sensor - 3 Pack - CPU: MCU 40MHz - Networking: Bluetooth 5.0, BLE - Ma. TX power: 5 dBm - Max power consumption: 77mW - Power method: Lithium battery CR123A - Features: Motion sensor (5m max range), Magnetic entry sensor for door/window open/close, Accelerometer for garage door open/close, Temperature sensor, Humidity sensor, Ambient light sensor, Alarm sound sensor - Antenna: 2.4 GHz - Antenna gain: 0.5 dBi - UP-Sense-3',200.00,'./product-images/sensors/sensor1.webp',_binary '','sensor'),(8,'Aqara Door and Window Sensor P2','Aqara Door and Window Sensor P2 - Native Matter Support - Build upon Thread Protocol - Local Home Automations - Local and Remote Alarm - Easy and Flexible Installation - Bluetooth Connection - DW-S02D',89.00,'./product-images/sensors/sensor2.jpeg',_binary '','sensor'),(9,'Aqara Presence Sensor FP2','Aqara Presence Sensor FP2 - Wireless Connection - Zone Positioning - Multi-Person Detection - Ultra-High Precision - Multi-Ecosystem Support - Flexible Placement - Built-In Light Sensor - Local Automations - Fall Detection and Alerts - USB-C Port - IPX5 Rating - PS-S02D',99.00,'./product-images/sensors/sensor3.webp',_binary '','sensor'),(10,'TP-Link Tapo T300 Smart Water Leak Sensor','TP-Link Tapo T300 Smart Water Leak Sensor - Hub Required: Yes - Wireless: 922 MHz - Package Contents: Tapo T300, 2x AAA Batteries (included), Quick Start Guide - IP67 Waterproof Rating - Built-in 90 dB Adjustable Siren - Tapo T300',119.00,'./product-images/sensors/sensor4.webp',_binary '','sensor'),(11,'Aqara D100 Smart Door Lock','Aqara D100 Smart Door Lock - Wireless Protocols: Bluetooth 5.0, Zigbee, NFC - Operating Temperature: -10 degrees Celsius to 55 degrees Celsius - ZNMS20LM',39.00,'./product-images/locks/lock1.jpeg',_binary '','lock'),(12,'Aqara A100 Smart Door Lock','Aqara A100 Smart Door Lock - Wireless Protocols: Bluetooth 5.0, Zigbee, NFC - Operating Temperature: -25 degrees Celsius to 55 degrees Celsius - ZNMS02ES',49.00,'./product-images/locks/lock2.jpeg',_binary '','lock'),(13,'Aqara Smart Door Lock A100 + Hub E1 Bundle','Aqara Smart Door Lock A100 (Wireless Protocols: Bluetooth 5.0, Zigbee, NFC - Operating Temperature: -25 degrees Celsius to 55 degrees Celsius) - Hub E1 (Max Connected Devices: Up to 128 - Connectivity: Wi-Fi IEEE 802.11b/g/n 2.4GHz, Zigbee 3.0 IEEE 802.15.4 - I/O: USB-A Male - Power: USB-A 5V 0.5A - 210-degree Adjustable Shaft - Compatible with Popular Voice Assistants',59.00,'./product-images/locks/lock3.jpeg',_binary '','lock'),(14,'AMD Ryzen 7 5700X 8 Core AM4 3.4GHz Unlocked CPU Processor','AMD Ryzen 7 5700X 8 Core AM4 3.4GHz Unlocked CPU Processor - Number of Cores: 8 - Number of Threads: 16 - Max Boost Clock: Up to 4.6 GHz - Base Clock: 3.4 GHz - Total L2 Cache: 4MB - Total L3 Cache: 32MB - Default TDP: 65W - Socket: AM4 - 100-100000926WOF - 3 Years Limited Warranty',699.00,'./product-images/processors/processor1.webp',_binary '','processor'),(15,'Intel Core i5 12400F 6 Core LGA 1700 2.5GHz CPU Processor','Intel Core i5 12400F 6 Core LGA 1700 2.5GHz CPU Processor - Socket Type: LGA 1700 - Core Count: 6x Performance - Thread Count: 12 - Clock Speed: 2.5 GHz Base, Up to 4.4 GHz Turbo - Total L3 Cache: 18MB - Integrated Graphics: N/A - TDP: 65W - BX8071512400F - 3 Years Limited Warranty',450.00,'./product-images/processors/processor2.webp',_binary '','processor'),(16,'MD Ryzen 5 5500 6-Core AM4 3.6GHz Unlocked CPU Processor + Wraith Stealth','AMD Ryzen 5 5500 6-Core AM4 3.6GHz Unlocked CPU Processor + Wraith Stealth - Number of Cores: 6 - Number of Threads: 12 - Max. Boost Clock: Up to 4.2GHz - Base Clock: 3.6GHz - Total L1 Cache: 384KB - Total L2 Cache: 3MB - Total L3 Cache: 16MB - Default TDP: 65W - Processor Technology for CPU Cores: TSMC 7nm FinFET - CPU Socket: AM4 - Thermal Solution Included: AMD Wraith Stealth - 100-100000457BOX - 3 Years Limited Warranty',499.00,'./product-images/processors/processor3.webp',_binary '','processor'),(17,'Intel Core i7 14700KF 20 Core LGA 1700 Unlocked CPU Processor','Intel Core i7 14700KF 20 Core LGA 1700 Unlocked CPU Processor - Generation: 14th Gen Raptor Lake Refresh - Socket: LGA 1700 - Total Cores: 20 - Performance-cores: 8 - Efficient-cores: 12 - Total Threads: 28 - Single Performance-core Max Turbo Frequency: 5.5 GHz - Single Efficient-core Max Turbo Frequency: 4.3 GHz - Intel L3 Smart Cache: 33MB - Processor Base Power: 125 W - BX8071514700KF',799.00,'./product-images/processors/processor4.webp',_binary '','processor'),(18,'AMD Ryzen 5 5600X 6-Core AM4 3.70 GHz Unlocked CPU Processor + Wraith Stealth','AMD Ryzen 5 5600X 6-Core AM4 3.70 GHz Unlocked CPU Processor + Wraith Stealth Cooler - Number of Cores: 6 - Number of Threads: 12 - Base Clock: 3.70 GHz - Max Boost Clock: Up to 4.60 GHz - Total L2 Cache: 3MB - Total L3 Cache: 32MB - Unlocked: Yes - CMOS: TSMC 7nm FinFET - Socket: AM4 - PCI Express® Version: PCIe 4.0 - Thermal Solution: Wraith Stealth Cooler - Default TDP: 65W - 100-100000065BOX - 3 Years Limited Warranty',579.00,'./product-images/processors/processor5.webp',_binary '','processor'),(19,'Intel Core i7-12700F 12 Core LGA 1700 2.1GHz CPU Processor','Intel Core i7-12700F 12 Core LGA 1700 2.1GHz CPU Processor - Socket Type: LGA 1700 - Core Count: 4x Efficiency, 8x Performance - Thread Count: 20 - Clock Speed: 2.1 GHz Base, Up to 4.9 GHz Turbo - Total L3 Cache: 25MB - Graphics: Integrated Graphics - TDP: 65W - BX8071512700F - 3 Years Limited Warranty',619.00,'./product-images/processors/processor6.webp',_binary '','processor'),(20,'AMD Ryzen 5 5600 6-Core AM4 3.5GHz Unlocked CPU Processor + Wraith Stealth','AMD Ryzen 5 5600 6-Core AM4 3.5GHz Unlocked CPU Processor + Wraith Stealth - Number of Cores: 6 - Number of Threads: 12 - Max. Boost Clock: Up to 4.4GHz - Base Clock: 3.5GHz - Total L1 Cache: 384KB - Total L2 Cache: 3MB - Total L3 Cache: 32MB - Default TDP: 65W - Processor Technology for CPU Cores: TSMC 7nm FinFET - CPU Socket: AM4 - Thermal Solution Included: AMD Wraith Stealth - 100-100000927BOX - 3 Years Limited Warranty',649.00,'./product-images/processors/processor7.webp',_binary '','processor'),(21,'Intel Core i7 12700KF 12 Core 2.7GHz LGA 1700 Unlocked CPU Processor','Intel Core i7-12700KF 12 Core LGA 1700 Unlocked CPU Processor - Socket: LGA 1700 - Total Cores: 12 - Total Threads: 20 - P-Core Base / Boost (Max): 3.6 / 5.0 GHz - P-Core Boost (All-Core): 4.7 GHz (All Core) - E-Core Base / Boost: TBA / 3.8 GHz - E-Core Boost (All-Core): 3.6 GHz (All Core) - Cache: 25 MB - TDP: 125W - Integrated Graphics: No - 3 Years Limited Warranty',599.00,'./product-images/processors/processor8.webp',_binary '','processor'),(22,'Intel Core i5 14600KF 14 Core LGA 1700 Unlocked CPU Processor','Intel Core i5 14600KF 14 Core LGA 1700 Unlocked CPU Processor - Generation: 14th Gen Raptor Lake Refresh - Socket: LGA 1700 - Total Cores: 14 - Performance-cores: 6 - Efficient-cores: 8 - Total Threads: 20 - Single Performance-core Max Turbo Frequency: 5.3 GHz - Single Efficient-core Max Turbo Frequency: 4.0 GHz - Intel L3 Smart Cache: 24MB - Processor Base Power: 125 W - BX8071514600KF',519.00,'./product-images/processors/processor9.webp',_binary '','processor'),(23,'AMD Ryzen 7 5700X3D 8-Core AM4 3.00 GHz CPU Processor','AMD Ryzen 7 5700X3D 8-Core AM4 3.00 GHz CPU Processor - CPU Cores: 8 - Threads: 16 - Base Clock: 3.00 GHz - Max. Boost Clock: Up to 4.1 GHz - L3 Cache: 96MB - CPU Socket: AM4 - Processor Technology for CPU Cores: TSMC 7nm FinFET - 100-100001503WOF',589.00,'./product-images/processors/processor10.webp',_binary '','processor'),(24,'AMD Ryzen 7 5800X 8-Core AM4 3.80 GHz Unlocked CPU Processor','AMD Ryzen 7 5800X 8-Core AM4 3.80 GHz Unlocked CPU Processor - Number of Cores: 8 - Number of Threads: 16 - Base Clock: 3.80 GHz - Max Boost Clock: Up to 4.70 GHz - Total L2 Cache: 4MB - Total L3 Cache: 32MB - Unlocked: Yes - CMOS: TSMC 7nm FinFET - Socket: AM4 - PCI Express® Version: PCIe 4.0 - Thermal Solution: N/A - Default TDP: 105W - 100-100000063WOF - 3 Years Limited Warranty',619.00,'./product-images/processors/processor11.webp',_binary '','processor'),(25,'Intel Core i9 14900KF 24 Core LGA 1700 Unlocked CPU Processor','Intel Core i9 14900KF 24 Core LGA 1700 Unlocked CPU Processor - Generation: 14th Gen Raptor Lake Refresh - Socket: LGA 1700 - Total Cores: 24 - Performance-cores: 8 - Efficient-cores: 16 - Total Threads: 32 - Single Performance-core Max Turbo Frequency: 5.6 GHz - Single Efficient-core Max Turbo Frequency: 4.4 GHz - Intel L3 Smart Cache: 36MB - Processor Base Power: 125 W - Intel Thermal Velocity Boost Frequency: Up to 6.0 GHz - BX8071514900KF',899.00,'./product-images/processors/processor12.webp',_binary '','processor'),(26,'Ubiquiti Networks U6-Pro UniFi 6 Dual Band WiFi 6 Access Point','Ubiquiti Networks U6-Pro UniFi 6 Dual Band WiFi 6 Access Point - No PoE Injector included - Weatherproofing: IP54 - Management interfaces: Ethernet, Bluetooth - Networking interface: 1xGbE RJ45 - Power method: 802.3at PoE+ - Standards: 802.11a/b/g, WiFi 4/WiFi 5/WiFi 6 - Dual Band: 5GHz (4x4 MU-MIMO) band with up to 4.8 Gbps, 2.4GHz (2x2 MIMO) band with up to 573.5 Mbps - Included: universal mounting plate, backing plate, and screw kit - U6-Pro - 12 Months Limited Warranty',29.00,'./product-images/accesspoints/accesspoint1.webp',_binary '','access point'),(27,'Ubiquiti Networks U6 Plus UniFi PoE Compact Wi-Fi 6 Access Point','Ubiquiti Networks U6Plus UniFi PoE Compact Wi-Fi 6 Access Point - Interface: 1x GbE RJ45 - Management interface: Ethernet - Power method: PoE - MIMO: 2.4GHz 2x2, 5 GHz: 2x2 - Throughput rate: 2.4 GHz: 573.5 Mbps, 5 GHz: 2402 Mbps - WiFi standards: 802.11a/b/g, WiFi 4/WiFi 5/WiFi 6 - U6+',32.00,'./product-images/accesspoints/accesspoint2.webp',_binary '','access point'),(28,'TP-Link TL-WA1201 AC1200 Wireless Access Point','TP-Link TL-WA1201 AC1200 Wireless Access Point - Interface: 1x 10/100/1000 Mbps Ethernet Port - External Power Supply: 12V/1.5A - Wireless Standards: IEEE802.11b/g/n 2.4 GHz, IEEE 802.11ac/n/a 5 GHz - TL-WA1201 - 3 Years Limited Warranty',39.00,'./product-images/accesspoints/accesspoint3.webp',_binary '','access point'),(29,'TP-Link EAP110 300Mbps Wireless N Ceiling Mount Access Point','TP-Link EAP110 300Mbps Wireless N Ceiling Mount Access Point - 2.4-2.4835GHz - IEEE 802.11n, IEEE 802.11g, IEEE 802.11b - 1x RJ-45 Fast Ethernet Port (Support Passive PoE) - 2x Internal 3dBi Omni Antennas - 5 Years Limited Warranty',99.00,'./product-images/accesspoints/accesspoint4.jpeg',_binary '','access point'),(30,'TP-Link Deco X20 AX1800 Whole Home Mesh Wi-Fi System - 3-Pack','TP-Link Deco X20 AX1800 Whole Home Mesh Wi-Fi System - 3-Pack - Wi-Fi 6 Technology - Seamless Roaming - TP-Link HomeCare - Deco App - AC Adapter Input: 100-240V~50-60Hz 0.6A - AC Adapter Output: 12 V/1.5 A - Hardware Ports: 2x 10/100/1000 Mbps RJ45 - Wireless Standards: IEEE 802.11a/n/ac/ax 5GHz, IEEE 802.11b/g/n/ax 2.4GHz - Supports IPv4 & IPv6 - Deco X20(3-pack) - 3 Years Limited Warranty',99.00,'./product-images/accesspoints/accesspoint5.webp',_binary '','access point'),(31,'HP LaserJet Pro 4301fdw A4 Colour Wireless Multifunction Laser Printer','HP LaserJet Pro 4301fdw A4 Colour Wireless Multifunction Laser Printer - Printer Functions: Print, Scan, Copy & Fax - Print Speed (Mono): Up to 21 ~ 30 ppm - First Page Out: As Fast as 9.5s (Black) / 10.2s (Colour) - Automatic Duplex - Resolution: Up to 600 x 600 DPI - Print Technology: Laser - Display: 4.3\" Display - Connectivity: Built in Dual Band WiFi, Ethernet, Bluetooth LE - Sheet Capacity: Up to 150 Sheets - 4RA82F (Replaces M479FDW) Uses 210A & 210X Toners',799.00,'./product-images/printers/printer1.webp',_binary '','printer'),(32,'Kyocera ECOSYS P4140DN A3/A4 Mono Laser Business Printer','Kyocera ECOSYS P4140DN A3/A4 Mono Laser Business Printer - Auto Duplex (2-Sided) Printing - Upto 40ppm A4 / 22ppm A3 Single Sided & 28ppm A4 / 11ppm Duplex - 1200dpi - USB & RJ45 LAN Connection - Upto 5 Additional Paper Trays PF-4110 Supported - 5 Lines LCD With Numeric Keypad - Uses Toner TK-7314 With Upto 15 000 Pages Yield (A4)',999.00,'./product-images/printers/printer2.webp',_binary '','printer'),(33,'ASUS PCE-AX58BT AX3000 Dual Band PCI-E WiFi 6 Adapter','ASUS PCE-AX58BT AX3000 Dual Band PCI-E WiFi 6 Adapter - 2 External Antennas - Bluetooth 5.0 Technology - AX 3000 (2402Mbps+574Mbps) - Operating Frequency: 2.4 / 5 GHz - 802.11a/b/g/n/ax - 12 Months Limited Warranty',19.00,'./product-images/dongles/dongle1.webp',_binary '','dongle'),(34,'TP-Link Archer TX55E V2 AX3000 Wi-Fi 6 Bluetooth 5.2 PCIe Adapter','TP-Link Archer TX55E V2 AX3000 Wi-Fi 6 Bluetooth 5.2 PCIe Adapter - Chipset: intel Wi-Fi 6 Chipset - Wireless Security: 64/128 bit WEP, WPA/WAP2/WPA3, WPA-PSK/WPA2-PSK, 802.1x - Bluetooth 5.2 - Antenna Type: Two High-Gain Dual Band Antennas - Archer-TX55E',15.00,'./product-images/dongles/dongle2.webp',_binary '','dongle'),(35,'ASUS PCE-AX3000 Dual Band WiFi 6 Bluetooth 5.0 PCI-E Adapter','ASUS PCE-AX3000 Wireless Dual Band PCI-Express Adapter - Network Standard: IEEE 802.11 ax, Bluetooth® 5.0 - Product Segment: AX 3000 (2402Mbps+574Mbps) - Operating Frequency: 2.4 GHz/5 GHz - Interface: PCI-Express - PCE-AX3000 - 3 Years Limited Warranty',18.00,'./product-images/dongles/dongle3.webp',_binary '','dongle'),(36,'SilverStone WAD17 Dual-Band High Gain Wi-Fi Antenna','SilverStone WAD17 Dual-Band High Gain Wi-Fi Antenna - Frequency: 2400~2500MHz, 5150~5875MHz - Gain: 2.4~2.5GHz 5dBi, 5.1~5.8GHz 7dBi - Connector: SMA plug RP - Omni-directional - Fastest way to improve Wi-Fi signal - SST-WAD17 - 12 Months Limited Warranty',23.00,'./product-images/dongles/dongle4.webp',_binary '','dongle'),(37,'ASUS USB-AX56 AX1800 Dual Band Wi-Fi 6 USB Adapter','ASUS USB-AX56 AX1800 Dual Band Wi-Fi 6 USB Adapter - Standards: 802.11a/b/g/n/ac/ax - Wi-Fi Speeds: 2.4GHz (ax): Up to 574 Mbps, 5GHz (ax): Up to 1201 Mbps - OS Support: Windows 10 - Security: Supports WPA3 - External Antennas - USB-AX56 - 12 Months Limited Warranty',21.00,'./product-images/dongles/dongle5.jpeg',_binary '','dongle'),(38,'TP-Link Archer TX3000E AX3000 Wi-Fi 6 Bluetooth 5.0 PCIe Adapter','TP-Link Archer TX3000E AX3000 Wi-Fi 6 Bluetooth 5.0 PCIe Adapter - Interface: PCI Express x1/x4/x8 - Supports Bluetooth 5.0/4.2/4.0 - Intel WiFi 6 Chipset - Wireless Standards: iEEE 802.11ax/ac/n/a 5 GHz & IEEE 802.11ax/n/g/b 2.4 GHz - 3 Years Limited Warranty',30.00,'./product-images/dongles/dongle6.webp',_binary '','dongle'),(39,'TP-Link Archer TX20E AX1800 Dual-Band Wi-Fi 6 Bluetooth 5.2 PCIe Adapter','TP-Link Archer TX20E AX1800 Dual-Band Wi-Fi 6 Bluetooth 5.2 PCIe Adapter - Antennas: 2x High-Gain Dual Band - Standards: IEEE 802.11ax/ac/n/a 5 GHz, ax/n/g/b 2.4 GHz, Bluetooth 5.2 - Max Signal Rate: 5 GHz: 11ax: Up to 1201 Mbps(dynamic), 2.4 GHz: 11ax: Up to 574 Mbps(dynamic) - Security: 64/128 bit WEP, WPA/WAP2/WPA3, WPA-PSK/WPA2-PSK, 802.1x - System Requirements: Windows 11/10(64-bit) only - Archer TX20E',20.00,'./product-images/dongles/dongle7.webp',_binary '','dongle'),(40,'Ubiquiti Networks UniFi Video UVC-G3-Flex Camera','Ubiquiti Networks UBNT - UniFi Video G3-FLEX Camera - Full HD 1080p resolution - Built-in IR illuminators for night vision - Powered by 802.3af Power over Ethernet - High sensitivity microphone - Wall mount, pole mount, and flat surface mounts included - Weather resistant for outdoor operation - UVC-G3-Flex - 12 Months Warranty',170.00,'./product-images/cameras/camera1.webp',_binary '','camera'),(41,'Aqara G2H Pro 1080p Camera Hub','Aqara G2H Pro 1080p Camera Hub - Supports HomeKit, Google, Alexa, IFTTT, Yandex, Marusya - FOV: 146 Degrees - MicroSD Support: Up to 512GB - Zigbee 3.0 Hub - WiFi: 2.4 GHz (WPA3 Supported) - Power Supply: 5V1A (Not Included) - LED Indicator - Full HD 1080p - IR Night Vision - Video Coding: H.264 - Overall Power Consumption: 5 W - CH-C01 - 12 Months Limited Warranty',105.00,'./product-images/cameras/camera2.webp',_binary '','camera'),(42,'TP-Link VIGI 4MP C540(4mm) Outdoor Full-Colour Pan Tilt Network Camera','TP-Link VIGI 4MP C540(4mm) Outdoor Full-Colour Pan Tilt Network Camera - 4MP High Definition - 24h Full-Colour - Powerful Pan Tilt - Waterproof - H.265+ - PoE/12V DC - VIGI App - Smart Detection - IP66 Rating - Image Sensor: 1/3 Progressive Scan CMOS - Shutter Speed: 1/3 to 1/10000s - Aperture: 4 mm: F1.6 - Lens Mount: M12 - IR Working Distance: 30m - Illumination Distance: 30m - VIGI C540(4mm)',199.00,'./product-images/cameras/camera3.jpeg',_binary '','camera'),(43,'TP-Link VIGI 4MP C340(6mm) Outdoor Full-Colour Bullet Network Camera','TP-Link VIGI 4MP C340(6mm) Outdoor Full-Colour Bullet Network Camera - 4MP High Definition - 24h Full-Colour - Waterproof IP66 Rating - Smart Detection (human detection, motion detection, area intrusion, line-crossing, video tampering) - H.265+ - PoE/12V DC - VIGI App - Image Sensor: 1/3 Progressive Scan CMOS - Shutter Speed: 1/3 to 1/10000 s - M12 Lens Mount - IR Working Distance: 30m - VIGI C340(6mm)',189.00,'./product-images/cameras/camera4.webp',_binary '','camera'),(44,'Ubiquiti Networks UNVR-Pro UniFi 2U 7-Bay Pro Network Video Recorder','Ubiquiti Networks UNVR-Pro UniFi 2U 7-Bay Pro Network Video Recorder - Drive Bays: 7x 2.5\"/3.5\" HDD Bays - Ports: 1x 10G SFP+, 1x 1GbE RJ45 - RF Interface: Bluetooth v4.1 - LCM Display: 1.3\" Touchscreen - Management Interface: Ethernet In-Band Management - ESD/EMP Protection: Air: ± 12kV, Contact: ± 8kV - Power Supply: AC/DC, Internal 200W - Max. Power Consumption: 160W - Max. Power Budget for Drives: 135W - UNVR-PRO - 12 Months Limited Warranty',200.00,'./product-images/recorders/recorder1.webp',_binary '','recorder'),(45,'TP-Link VIGI NVR1004H-4P 4 Channel PoE+ Network Video Recorder','TP-Link VIGI NVR1004H-4P 4 Channel PoE+ Network Video Recorder - Protocol: TCP/IP, DHCP, DNS, NTP, UPnP - Incoming Bandwith: 80 Mbps - Outgoing Bandwidth: 60 Mbps - Video Input: 4-Channel IP Video Input, up to 8MP - Decoding Format: H.265+/H.265/ H.264+/H.264 - Synchronous Playback: 4 Channel - SATA: 1 SATA Interface - Capacity: Up to 10TB - Network Interface: RJ45 100Mbps, 2x USB-A 2.0 - VIGI NVR1004H-4P',249.00,'./product-images/recorders/recorder2.webp',_binary '','recorder');
/*!40000 ALTER TABLE `Products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-12 15:03:01

select * FROM products;