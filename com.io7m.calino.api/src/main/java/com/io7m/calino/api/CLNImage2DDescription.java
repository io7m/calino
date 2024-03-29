/*
 * Copyright © 2021 Mark Raynsford <code@io7m.com> https://www.io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.calino.api;

/**
 * A description of a single 2D image.
 *
 * @param mipMapLevel             The mipmap level
 * @param dataOffsetWithinSection The offset of the data from the start of the
 *                                section data
 * @param dataSizeCompressed      The size of the supercompressed data
 * @param dataSizeUncompressed    The size of the uncompressed data
 * @param crc32Uncompressed       The CRC32 of the uncompressed data
 */

public record CLNImage2DDescription(
  int mipMapLevel,
  long dataOffsetWithinSection,
  long dataSizeUncompressed,
  long dataSizeCompressed,
  int crc32Uncompressed)
  implements CLNImageDescriptionType, Comparable<CLNImage2DDescription>
{

  @Override
  public int compareTo(
    final CLNImage2DDescription other)
  {
    return Integer.compareUnsigned(other.mipMapLevel(), this.mipMapLevel());
  }
}
