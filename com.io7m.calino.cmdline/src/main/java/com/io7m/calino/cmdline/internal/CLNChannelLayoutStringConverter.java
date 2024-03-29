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

package com.io7m.calino.cmdline.internal;

import com.beust.jcommander.IStringConverter;
import com.io7m.calino.api.CLNChannelsLayoutDescriptionType;
import com.io7m.calino.api.CLNChannelsLayoutDescriptions;

import java.text.ParseException;

/**
 * A channel layout string converter.
 */

public final class CLNChannelLayoutStringConverter
  implements IStringConverter<CLNChannelsLayoutDescriptionType>
{
  /**
   * A channel layout string converter.
   */

  public CLNChannelLayoutStringConverter()
  {

  }

  @Override
  public CLNChannelsLayoutDescriptionType convert(
    final String value)
  {
    try {
      return CLNChannelsLayoutDescriptions.parseLayoutDescriptor(value);
    } catch (final ParseException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
