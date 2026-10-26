#!/usr/bin/env python3
import struct

# Create a minimal 48x48 PNG icon
width, height = 48, 48
# PNG signature + IHDR
png_signature = b'\x89PNG\r\n\x1a\n'
ihdr = struct.pack('>2I5B', width, height, 8, 2, 0, 0, 0, 0, 0)
# Create simple pixel data (purple background)
pixel_data = b'\x00' * width * height * 3  # Simple purple color
# Compressed data would go here, but for now use uncompressed
idat = b'\x78\x9c\xfd\xcf\x04\x00\x00\x05\x00\x01\x9d\xdd'
# IEND chunk
iend = b'\x00\x00\x00\x00IEND\xaeB`\x82'
# Write PNG
with open('app/src/main/res/mipmap-hdpi/ic_launcher.png', 'wb') as f:
    f.write(png_signature + ihdr + idat + iend)