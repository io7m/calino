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

import java.util.Comparator;

/**
 * A description of a single array image.
 *
 * @param mipMapLevel             The mipmap level
 * @param layer                   The layer
 * @param dataOffsetWithinSection The offset of the data from the start of the
 *                                section data
 * @param dataSizeCompressed      The size of the supercompressed data
 * @param dataSizeUncompressed    The size of the uncompressed data
 * @param crc32Uncompressed       The CRC32 of the uncompressed data
 */

public record CLNImageArrayDescription(
  int mipMapLevel,
  int layer,
  long dataOffsetWithinSection,
  long dataSizeUncompressed,
  long dataSizeCompressed,
  int crc32Uncompressed)
  implements CLNImageDescriptionType, Comparable<CLNImageArrayDescription>
{
  @Override
  public int compareTo(
    final CLNImageArrayDescription other)
  {
    return ((Comparator<CLNImageArrayDescription>) (o1, o2) -> {
      return Integer.compareUnsigned(o1.mipMapLevel(), o2.mipMapLevel());
    }).reversed()
      .thenComparing((o1, o2) -> {
        return Integer.compareUnsigned(o1.layer(), o2.layer());
      }).compare(this, other);
  }
}
